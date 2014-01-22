package com.baidu.tieba.data.chat;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.g.e;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.by;
import com.baidu.tieba.util.p;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private LinkedList<Integer> a = new LinkedList<>();

    public void a() {
        new b(this).start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(RecentChatFriendData recentChatFriendData) {
        SQLiteDatabase a = DatabaseService.a();
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
            contentValues.put("unReadCount", Integer.valueOf(recentChatFriendData.unReadCount));
            int update = a.update("chat_recent_friends", contentValues, "pk = ?", new String[]{recentChatFriendData.getPK()});
            if (update == 0) {
                a.insert("chat_recent_friends", null, contentValues);
            }
            e.d("affectedRows:" + update + " msg.ownerName:" + recentChatFriendData.ownerName + " msg.ownerId:" + recentChatFriendData.ownerId + " unreadCount" + recentChatFriendData.getUnReadCount());
        } catch (Throwable th) {
            by.a(th, "ChatDBManager.addOrUpdateRecentChatFriend", new Object[0]);
            e.b("DatabaseService", "addOrUpdateRecentChatFriend", th.getMessage());
        }
    }

    public List<RecentChatFriendData> a(String str, int i) {
        int i2 = 0;
        SQLiteDatabase a = DatabaseService.a();
        Cursor cursor = null;
        try {
            cursor = a.rawQuery("SELECT * FROM chat_recent_friends where ownerId = ? order by serverTime desc", new String[]{str});
            LinkedList linkedList = new LinkedList();
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("pk"));
                if (i2 >= i) {
                    a.delete("chat_recent_friends", "pk = ?", new String[]{string});
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
                    recentChatFriendData.unReadCount = cursor.getInt(cursor.getColumnIndex("unReadCount"));
                    linkedList.add(recentChatFriendData);
                    i2++;
                }
            }
            return linkedList;
        } catch (Throwable th) {
            try {
                by.a(th, "ChatDBManager.listRecentChatFriends", new Object[0]);
                e.b("DatabaseService", "listRecentChatFriends", th.getMessage());
                p.a(cursor);
                return new LinkedList();
            } finally {
                p.a(cursor);
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
                e.d("query:" + TiebaApplication.A() + "___" + i + " gid:" + str);
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
                    recentChatFriendData.unReadCount = cursor.getInt(cursor.getColumnIndex("unReadCount"));
                    linkedList.add(recentChatFriendData);
                    i2++;
                }
                e.d("count:" + i2);
                if (i2 <= 0) {
                    return null;
                }
                return linkedList;
            } catch (Throwable th) {
                th = th;
                try {
                    by.a(th, "ChatDBManager.getGroupNewsInfo", new Object[0]);
                    e.b("DatabaseService", "listRecentChatFriends", th.getMessage());
                    return null;
                } finally {
                    p.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public void a(String str, String str2) {
        SQLiteDatabase a = DatabaseService.a();
        e.d("ownerId:" + str + " frientId:" + str2);
        try {
            a.delete("chat_recent_friends", "ownerId = ? and friendId = ?", new String[]{str, str2});
        } catch (Throwable th) {
            by.a(th, "ChatDBManager.deleteRecentChatMessage", new Object[0]);
            e.b("DatabaseService", "deleteChatMessagesByFriendId", th.getMessage());
        }
    }
}
