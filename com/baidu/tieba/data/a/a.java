package com.baidu.tieba.data.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.av;
import com.tencent.mm.sdk.conversation.RConversation;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<Integer> f984a = new LinkedList<>();

    public void a() {
        new b(this).start();
    }

    public boolean a(d dVar) {
        SQLiteDatabase a2 = DatabaseService.a();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("msgId", Long.valueOf(dVar.f987a));
            contentValues.put("ownerId", dVar.b);
            contentValues.put("friendId", dVar.c);
            contentValues.put(RConversation.COL_MSGTYPE, Integer.valueOf(dVar.d));
            contentValues.put("status", Integer.valueOf(dVar.e));
            contentValues.put("localTime", Long.valueOf(dVar.f));
            contentValues.put("serverTime", Long.valueOf(dVar.g));
            contentValues.put("msgContent", dVar.h);
            a2.insert("chat_msgs", null, contentValues);
            return true;
        } catch (Throwable th) {
            av.b("DatabaseService", "addChatMessage", th.getMessage());
            return false;
        }
    }

    public List<d> a(String str, String str2, int i) {
        SQLiteDatabase a2 = DatabaseService.a();
        Cursor cursor = null;
        try {
            cursor = a2.rawQuery("SELECT * FROM chat_msgs where ownerId = ? and friendId = ? order by msgId desc", new String[]{str, str2});
            return a(a2, cursor, i);
        } catch (Throwable th) {
            try {
                av.b("DatabaseService", "listChatMessagesByFriendId", th.getMessage());
                com.baidu.tieba.util.g.a(cursor);
                return new LinkedList();
            } finally {
                com.baidu.tieba.util.g.a(cursor);
            }
        }
    }

    protected List<d> a(SQLiteDatabase sQLiteDatabase, Cursor cursor, int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        int i2 = 0;
        while (cursor.moveToNext()) {
            int i3 = cursor.getInt(cursor.getColumnIndex("pk"));
            if (i2 >= i) {
                a(i3);
            } else {
                d dVar = new d();
                dVar.f987a = cursor.getLong(cursor.getColumnIndex("msgId"));
                if (linkedList2.contains(Long.valueOf(dVar.f987a))) {
                    a(i3);
                } else {
                    dVar.b = cursor.getString(cursor.getColumnIndex("ownerId"));
                    dVar.c = cursor.getString(cursor.getColumnIndex("friendId"));
                    dVar.d = cursor.getInt(cursor.getColumnIndex(RConversation.COL_MSGTYPE));
                    dVar.e = cursor.getInt(cursor.getColumnIndex("status"));
                    dVar.f = cursor.getLong(cursor.getColumnIndex("localTime"));
                    dVar.g = cursor.getLong(cursor.getColumnIndex("serverTime"));
                    dVar.h = cursor.getString(cursor.getColumnIndex("msgContent"));
                    if (dVar.d != 99) {
                        linkedList.addFirst(dVar);
                        i2++;
                        z = false;
                    } else {
                        if (!z) {
                            linkedList.addLast(dVar);
                            linkedList2.add(Long.valueOf(dVar.f987a));
                        } else {
                            a(i3);
                        }
                        z = true;
                    }
                }
            }
        }
        a(sQLiteDatabase);
        return linkedList;
    }

    protected void a(int i) {
        if (!this.f984a.contains(Integer.valueOf(i))) {
            this.f984a.add(Integer.valueOf(i));
        }
    }

    protected void a(SQLiteDatabase sQLiteDatabase) {
        if (!this.f984a.isEmpty()) {
            sQLiteDatabase.beginTransaction();
            while (!this.f984a.isEmpty()) {
                try {
                    sQLiteDatabase.delete("chat_msgs", "pk = ?", new String[]{String.valueOf(this.f984a.removeFirst().intValue())});
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        }
    }

    public void a(String str, String str2) {
        SQLiteDatabase a2 = DatabaseService.a();
        try {
            if (str2 != null) {
                a2.delete("chat_msgs", "ownerId = ? and friendId = ?", new String[]{str, str2});
            } else {
                a2.delete("chat_msgs", "ownerId = ?", new String[]{str});
            }
        } catch (Throwable th) {
            av.b("DatabaseService", "deleteChatMessagesByFriendId", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, List<g> list) {
        SQLiteDatabase a2 = DatabaseService.a();
        try {
            a2.beginTransaction();
            a2.delete("chat_recent_friends", "ownerId = ?", new String[]{str});
            for (g gVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("pk", gVar.a());
                contentValues.put("ownerId", gVar.f990a);
                contentValues.put("friendId", gVar.c);
                contentValues.put("ownerName", gVar.b);
                contentValues.put("friendName", gVar.d);
                contentValues.put("friendPortrait", gVar.e);
                contentValues.put("status", Integer.valueOf(gVar.f));
                contentValues.put("localTime", Long.valueOf(gVar.g));
                contentValues.put("serverTime", Long.valueOf(gVar.h));
                contentValues.put("msgContent", gVar.i);
                contentValues.put(RConversation.COL_UNREAD_COUNT, Integer.valueOf(gVar.j));
                a2.insert("chat_recent_friends", null, contentValues);
            }
            a2.setTransactionSuccessful();
            a2.endTransaction();
        } catch (Throwable th) {
            av.b("DatabaseService", "addAndOverrideRecentChatFriends", th.getMessage());
        }
    }

    public List<g> a(String str, int i) {
        int i2 = 0;
        SQLiteDatabase a2 = DatabaseService.a();
        Cursor cursor = null;
        try {
            cursor = a2.rawQuery("SELECT * FROM chat_recent_friends where ownerId = ? order by serverTime desc", new String[]{str});
            LinkedList linkedList = new LinkedList();
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("pk"));
                if (i2 >= i) {
                    a2.delete("chat_recent_friends", "pk = ?", new String[]{string});
                } else {
                    g gVar = new g();
                    gVar.f990a = cursor.getString(cursor.getColumnIndex("ownerId"));
                    gVar.c = cursor.getString(cursor.getColumnIndex("friendId"));
                    gVar.b = cursor.getString(cursor.getColumnIndex("ownerName"));
                    gVar.d = cursor.getString(cursor.getColumnIndex("friendName"));
                    gVar.f = cursor.getInt(cursor.getColumnIndex("status"));
                    gVar.g = cursor.getLong(cursor.getColumnIndex("localTime"));
                    gVar.h = cursor.getLong(cursor.getColumnIndex("serverTime"));
                    gVar.e = cursor.getString(cursor.getColumnIndex("friendPortrait"));
                    gVar.i = cursor.getString(cursor.getColumnIndex("msgContent"));
                    gVar.j = cursor.getInt(cursor.getColumnIndex(RConversation.COL_UNREAD_COUNT));
                    linkedList.add(gVar);
                    i2++;
                }
            }
            return linkedList;
        } catch (Throwable th) {
            try {
                av.b("DatabaseService", "listRecentChatFriends", th.getMessage());
                com.baidu.tieba.util.g.a(cursor);
                return new LinkedList();
            } finally {
                com.baidu.tieba.util.g.a(cursor);
            }
        }
    }
}
