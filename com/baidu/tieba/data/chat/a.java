package com.baidu.tieba.data.chat;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bg;
import com.baidu.tieba.util.o;
import com.tencent.mm.sdk.conversation.RConversation;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<Integer> f1193a = new LinkedList<>();

    public void a() {
        new b(this).start();
    }

    public boolean a(ChatMessageData chatMessageData) {
        SQLiteDatabase a2 = DatabaseService.a();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("msgId", Long.valueOf(chatMessageData.msgId));
            contentValues.put("ownerId", chatMessageData.ownerId);
            contentValues.put("friendId", chatMessageData.friendId);
            contentValues.put(RConversation.COL_MSGTYPE, Integer.valueOf(chatMessageData.msgType));
            contentValues.put("status", Integer.valueOf(chatMessageData.status));
            contentValues.put("localTime", Long.valueOf(chatMessageData.localTime));
            contentValues.put("serverTime", Long.valueOf(chatMessageData.serverTime));
            contentValues.put("msgContent", chatMessageData.msgContent);
            a2.insert("chat_msgs", null, contentValues);
            return true;
        } catch (Throwable th) {
            bg.b("DatabaseService", "addChatMessage", th.getMessage());
            return false;
        }
    }

    public List<ChatMessageData> a(String str, String str2, int i) {
        SQLiteDatabase a2 = DatabaseService.a();
        Cursor cursor = null;
        try {
            cursor = a2.rawQuery("SELECT * FROM chat_msgs where ownerId = ? and friendId = ? order by msgId desc", new String[]{str, str2});
            return a(a2, cursor, i);
        } catch (Throwable th) {
            try {
                bg.b("DatabaseService", "listChatMessagesByFriendId", th.getMessage());
                o.a(cursor);
                return new LinkedList();
            } finally {
                o.a(cursor);
            }
        }
    }

    protected List<ChatMessageData> a(SQLiteDatabase sQLiteDatabase, Cursor cursor, int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        int i2 = 0;
        while (cursor.moveToNext()) {
            int i3 = cursor.getInt(cursor.getColumnIndex("pk"));
            if (i2 >= i) {
                a(i3);
            } else {
                ChatMessageData chatMessageData = new ChatMessageData();
                chatMessageData.msgId = cursor.getLong(cursor.getColumnIndex("msgId"));
                if (linkedList2.contains(Long.valueOf(chatMessageData.msgId))) {
                    a(i3);
                } else {
                    chatMessageData.ownerId = cursor.getString(cursor.getColumnIndex("ownerId"));
                    chatMessageData.friendId = cursor.getString(cursor.getColumnIndex("friendId"));
                    chatMessageData.msgType = cursor.getInt(cursor.getColumnIndex(RConversation.COL_MSGTYPE));
                    chatMessageData.status = cursor.getInt(cursor.getColumnIndex("status"));
                    chatMessageData.localTime = cursor.getLong(cursor.getColumnIndex("localTime"));
                    chatMessageData.serverTime = cursor.getLong(cursor.getColumnIndex("serverTime"));
                    chatMessageData.msgContent = cursor.getString(cursor.getColumnIndex("msgContent"));
                    if (chatMessageData.msgType != 99) {
                        linkedList.addFirst(chatMessageData);
                        i2++;
                        z = false;
                    } else {
                        if (!z) {
                            linkedList.addLast(chatMessageData);
                            linkedList2.add(Long.valueOf(chatMessageData.msgId));
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
        if (!this.f1193a.contains(Integer.valueOf(i))) {
            this.f1193a.add(Integer.valueOf(i));
        }
    }

    protected void a(SQLiteDatabase sQLiteDatabase) {
        if (!this.f1193a.isEmpty()) {
            sQLiteDatabase.beginTransaction();
            while (!this.f1193a.isEmpty()) {
                try {
                    sQLiteDatabase.delete("chat_msgs", "pk = ?", new String[]{String.valueOf(this.f1193a.removeFirst().intValue())});
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
        }
    }

    public void a(String str, String str2) {
        SQLiteDatabase a2 = DatabaseService.a();
        com.baidu.adp.lib.h.d.d("ownerId:" + str + " frientId:" + str2);
        try {
            if (str2 != null) {
                a2.delete("chat_msgs", "ownerId = ? and friendId = ?", new String[]{str, str2});
            } else {
                a2.delete("chat_msgs", "ownerId = ?", new String[]{str});
            }
        } catch (Throwable th) {
            bg.b("DatabaseService", "deleteChatMessagesByFriendId", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, List<RecentChatFriendData> list) {
        SQLiteDatabase a2 = DatabaseService.a();
        try {
            a2.beginTransaction();
            a2.delete("chat_recent_friends", "ownerId = ?", new String[]{str});
            for (RecentChatFriendData recentChatFriendData : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("pk", recentChatFriendData.getPK());
                contentValues.put("ownerId", recentChatFriendData.ownerId);
                contentValues.put("friendId", recentChatFriendData.friendId);
                contentValues.put("ownerName", recentChatFriendData.ownerName);
                contentValues.put("friendName", recentChatFriendData.friendName);
                contentValues.put("friendPortrait", recentChatFriendData.friendPortrait);
                contentValues.put("status", Integer.valueOf(recentChatFriendData.status));
                contentValues.put("localTime", Long.valueOf(recentChatFriendData.localTime));
                contentValues.put("serverTime", Long.valueOf(recentChatFriendData.serverTime));
                contentValues.put("msgContent", recentChatFriendData.msgContent);
                contentValues.put(RConversation.COL_UNREAD_COUNT, Integer.valueOf(recentChatFriendData.unReadCount));
                a2.insert("chat_recent_friends", null, contentValues);
            }
            a2.setTransactionSuccessful();
            a2.endTransaction();
        } catch (Throwable th) {
            bg.b("DatabaseService", "addAndOverrideRecentChatFriends", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(RecentChatFriendData recentChatFriendData) {
        SQLiteDatabase a2 = DatabaseService.a();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("pk", recentChatFriendData.getPK());
            contentValues.put("ownerId", recentChatFriendData.ownerId);
            contentValues.put("friendId", recentChatFriendData.friendId);
            contentValues.put("ownerName", recentChatFriendData.ownerName);
            contentValues.put("friendName", recentChatFriendData.friendName);
            contentValues.put("friendPortrait", recentChatFriendData.friendPortrait);
            contentValues.put("status", Integer.valueOf(recentChatFriendData.status));
            contentValues.put("localTime", Long.valueOf(recentChatFriendData.localTime));
            contentValues.put("serverTime", Long.valueOf(recentChatFriendData.serverTime));
            contentValues.put("msgContent", recentChatFriendData.msgContent);
            contentValues.put(RConversation.COL_UNREAD_COUNT, Integer.valueOf(recentChatFriendData.unReadCount));
            int update = a2.update("chat_recent_friends", contentValues, "pk = ?", new String[]{recentChatFriendData.getPK()});
            if (update == 0) {
                a2.insert("chat_recent_friends", null, contentValues);
            }
            com.baidu.adp.lib.h.d.d("affectedRows:" + update + " msg.ownerName:" + recentChatFriendData.ownerName + " msg.ownerId:" + recentChatFriendData.ownerId + " unreadCount" + recentChatFriendData.getUnReadCount());
        } catch (Throwable th) {
            bg.b("DatabaseService", "addOrUpdateRecentChatFriend", th.getMessage());
        }
    }

    public List<RecentChatFriendData> a(String str, int i) {
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
                    RecentChatFriendData recentChatFriendData = new RecentChatFriendData();
                    recentChatFriendData.ownerId = cursor.getString(cursor.getColumnIndex("ownerId"));
                    recentChatFriendData.friendId = cursor.getString(cursor.getColumnIndex("friendId"));
                    recentChatFriendData.ownerName = cursor.getString(cursor.getColumnIndex("ownerName"));
                    recentChatFriendData.friendName = cursor.getString(cursor.getColumnIndex("friendName"));
                    recentChatFriendData.status = cursor.getInt(cursor.getColumnIndex("status"));
                    recentChatFriendData.localTime = cursor.getLong(cursor.getColumnIndex("localTime"));
                    recentChatFriendData.serverTime = cursor.getLong(cursor.getColumnIndex("serverTime"));
                    recentChatFriendData.friendPortrait = cursor.getString(cursor.getColumnIndex("friendPortrait"));
                    recentChatFriendData.msgContent = cursor.getString(cursor.getColumnIndex("msgContent"));
                    recentChatFriendData.unReadCount = cursor.getInt(cursor.getColumnIndex(RConversation.COL_UNREAD_COUNT));
                    linkedList.add(recentChatFriendData);
                    i2++;
                }
            }
            return linkedList;
        } catch (Throwable th) {
            try {
                bg.b("DatabaseService", "listRecentChatFriends", th.getMessage());
                o.a(cursor);
                return new LinkedList();
            } finally {
                o.a(cursor);
            }
        }
    }

    public LinkedList<RecentChatFriendData> a(int i, String str) {
        Cursor cursor;
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            cursor = DatabaseService.a().rawQuery("SELECT * FROM chat_recent_friends where ownerId = ? and ownerName = ? and friendId = ? order by serverTime desc", new String[]{TiebaApplication.A(), String.valueOf(i), str});
            try {
                com.baidu.adp.lib.h.d.d("query:" + TiebaApplication.A() + "___" + i + " gid:" + str);
                LinkedList<RecentChatFriendData> linkedList = new LinkedList<>();
                while (cursor.moveToNext()) {
                    RecentChatFriendData recentChatFriendData = new RecentChatFriendData();
                    recentChatFriendData.ownerId = cursor.getString(cursor.getColumnIndex("ownerId"));
                    recentChatFriendData.friendId = cursor.getString(cursor.getColumnIndex("friendId"));
                    recentChatFriendData.ownerName = cursor.getString(cursor.getColumnIndex("ownerName"));
                    recentChatFriendData.friendName = cursor.getString(cursor.getColumnIndex("friendName"));
                    recentChatFriendData.status = cursor.getInt(cursor.getColumnIndex("status"));
                    recentChatFriendData.localTime = cursor.getLong(cursor.getColumnIndex("localTime"));
                    recentChatFriendData.serverTime = cursor.getLong(cursor.getColumnIndex("serverTime"));
                    recentChatFriendData.friendPortrait = cursor.getString(cursor.getColumnIndex("friendPortrait"));
                    recentChatFriendData.msgContent = cursor.getString(cursor.getColumnIndex("msgContent"));
                    recentChatFriendData.unReadCount = cursor.getInt(cursor.getColumnIndex(RConversation.COL_UNREAD_COUNT));
                    linkedList.add(recentChatFriendData);
                    i2++;
                }
                com.baidu.adp.lib.h.d.d("count:" + i2);
                if (i2 <= 0) {
                    return null;
                }
                return linkedList;
            } catch (Throwable th) {
                th = th;
                try {
                    bg.b("DatabaseService", "listRecentChatFriends", th.getMessage());
                    return null;
                } finally {
                    o.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public void b(String str, String str2) {
        SQLiteDatabase a2 = DatabaseService.a();
        com.baidu.adp.lib.h.d.d("ownerId:" + str + " frientId:" + str2);
        try {
            a2.delete("chat_recent_friends", "ownerId = ? and friendId = ?", new String[]{str, str2});
        } catch (Throwable th) {
            bg.b("DatabaseService", "deleteChatMessagesByFriendId", th.getMessage());
        }
    }
}
