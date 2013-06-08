package com.baidu.tieba.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private LinkedList a = new LinkedList();

    public void a() {
        new b(this).start();
    }

    public boolean a(d dVar) {
        SQLiteDatabase a = k.a();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("msgId", Long.valueOf(dVar.a));
            contentValues.put("ownerId", dVar.b);
            contentValues.put("friendId", dVar.c);
            contentValues.put("msgType", Integer.valueOf(dVar.d));
            contentValues.put("status", Integer.valueOf(dVar.e));
            contentValues.put("localTime", Long.valueOf(dVar.f));
            contentValues.put("serverTime", Long.valueOf(dVar.g));
            contentValues.put("msgContent", dVar.h);
            a.insert("chat_msgs", null, contentValues);
            return true;
        } catch (Throwable th) {
            ae.b("DatabaseService", "addChatMessage", th.getMessage());
            return false;
        }
    }

    public List a(String str, String str2, int i) {
        SQLiteDatabase a = k.a();
        Cursor cursor = null;
        try {
            cursor = a.rawQuery("SELECT * FROM chat_msgs where ownerId = ? and friendId = ? order by msgId desc", new String[]{str, str2});
            return a(a, cursor, i);
        } catch (Throwable th) {
            try {
                ae.b("DatabaseService", "listChatMessagesByFriendId", th.getMessage());
                com.baidu.tieba.d.f.a(cursor);
                return new LinkedList();
            } finally {
                com.baidu.tieba.d.f.a(cursor);
            }
        }
    }

    protected List a(SQLiteDatabase sQLiteDatabase, Cursor cursor, int i) {
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
                dVar.a = cursor.getLong(cursor.getColumnIndex("msgId"));
                if (linkedList2.contains(Long.valueOf(dVar.a))) {
                    a(i3);
                } else {
                    dVar.b = cursor.getString(cursor.getColumnIndex("ownerId"));
                    dVar.c = cursor.getString(cursor.getColumnIndex("friendId"));
                    dVar.d = cursor.getInt(cursor.getColumnIndex("msgType"));
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
                            linkedList2.add(Long.valueOf(dVar.a));
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
        if (!this.a.contains(Integer.valueOf(i))) {
            this.a.add(Integer.valueOf(i));
        }
    }

    protected void a(SQLiteDatabase sQLiteDatabase) {
        if (!this.a.isEmpty()) {
            sQLiteDatabase.beginTransaction();
            while (!this.a.isEmpty()) {
                try {
                    sQLiteDatabase.delete("chat_msgs", "pk = ?", new String[]{String.valueOf(((Integer) this.a.removeFirst()).intValue())});
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        }
    }

    public void a(String str, String str2) {
        SQLiteDatabase a = k.a();
        try {
            if (str2 != null) {
                a.delete("chat_msgs", "ownerId = ? and friendId = ?", new String[]{str, str2});
            } else {
                a.delete("chat_msgs", "ownerId = ?", new String[]{str});
            }
        } catch (Throwable th) {
            ae.b("DatabaseService", "deleteChatMessagesByFriendId", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, List list) {
        SQLiteDatabase a = k.a();
        try {
            a.beginTransaction();
            a.delete("chat_recent_friends", "ownerId = ?", new String[]{str});
            Iterator it = list.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                ContentValues contentValues = new ContentValues();
                contentValues.put("pk", gVar.a());
                contentValues.put("ownerId", gVar.a);
                contentValues.put("friendId", gVar.c);
                contentValues.put("ownerName", gVar.b);
                contentValues.put("friendName", gVar.d);
                contentValues.put("friendPortrait", gVar.e);
                contentValues.put("status", Integer.valueOf(gVar.f));
                contentValues.put("localTime", Long.valueOf(gVar.g));
                contentValues.put("serverTime", Long.valueOf(gVar.h));
                contentValues.put("msgContent", gVar.i);
                contentValues.put("unReadCount", Integer.valueOf(gVar.j));
                a.insert("chat_recent_friends", null, contentValues);
            }
            a.setTransactionSuccessful();
            a.endTransaction();
        } catch (Throwable th) {
            ae.b("DatabaseService", "addAndOverrideRecentChatFriends", th.getMessage());
        }
    }

    public List a(String str, int i) {
        int i2 = 0;
        SQLiteDatabase a = k.a();
        Cursor cursor = null;
        try {
            cursor = a.rawQuery("SELECT * FROM chat_recent_friends where ownerId = ? order by serverTime desc", new String[]{str});
            LinkedList linkedList = new LinkedList();
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("pk"));
                if (i2 >= i) {
                    a.delete("chat_recent_friends", "pk = ?", new String[]{string});
                } else {
                    g gVar = new g();
                    gVar.a = cursor.getString(cursor.getColumnIndex("ownerId"));
                    gVar.c = cursor.getString(cursor.getColumnIndex("friendId"));
                    gVar.b = cursor.getString(cursor.getColumnIndex("ownerName"));
                    gVar.d = cursor.getString(cursor.getColumnIndex("friendName"));
                    gVar.f = cursor.getInt(cursor.getColumnIndex("status"));
                    gVar.g = cursor.getLong(cursor.getColumnIndex("localTime"));
                    gVar.h = cursor.getLong(cursor.getColumnIndex("serverTime"));
                    gVar.e = cursor.getString(cursor.getColumnIndex("friendPortrait"));
                    gVar.i = cursor.getString(cursor.getColumnIndex("msgContent"));
                    gVar.j = cursor.getInt(cursor.getColumnIndex("unReadCount"));
                    linkedList.add(gVar);
                    i2++;
                }
            }
            return linkedList;
        } catch (Throwable th) {
            try {
                ae.b("DatabaseService", "listRecentChatFriends", th.getMessage());
                com.baidu.tieba.d.f.a(cursor);
                return new LinkedList();
            } finally {
                com.baidu.tieba.d.f.a(cursor);
            }
        }
    }
}
