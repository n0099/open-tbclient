package com.baidu.tbadk.editortool;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TiebaDatabase;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    private static u YN = new u();

    public static u vq() {
        return YN;
    }

    private u() {
    }

    public boolean a(EmotionGroupData emotionGroupData) {
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase ak = mainDBDatabaseManager.ak();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("groupId", emotionGroupData.groupId);
            contentValues.put("groupName", emotionGroupData.groupName);
            contentValues.put("groupDesc", emotionGroupData.groupDesc);
            contentValues.put("emotionsCount", Integer.valueOf(emotionGroupData.emotionsCount));
            contentValues.put("width", Integer.valueOf(emotionGroupData.width));
            contentValues.put("height", Integer.valueOf(emotionGroupData.height));
            contentValues.put("status", Integer.valueOf(emotionGroupData.status));
            contentValues.put("downloadTime", Long.valueOf(emotionGroupData.downloadTime));
            contentValues.put("bytesLength", Integer.valueOf(emotionGroupData.bytesLength));
            contentValues.put("bytesReceived", Integer.valueOf(emotionGroupData.bytesReceived));
            contentValues.put("downloadUrl", emotionGroupData.downloadUrl);
            ak.insert("emotion_group", null, contentValues);
            return true;
        } catch (Throwable th) {
            mainDBDatabaseManager.a(th, "EmotionsDBManager.addEmotionGroup");
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [120=4] */
    public EmotionGroupData dX(String str) {
        Cursor cursor;
        EmotionGroupData emotionGroupData = null;
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                cursor = mainDBDatabaseManager.ak().rawQuery("SELECT * FROM emotion_group where groupId = ? ", new String[]{str});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    emotionGroupData = e(cursor);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    mainDBDatabaseManager.a(th, "EmotionsDBManager.getEmotionGroup");
                    return emotionGroupData;
                } finally {
                    com.baidu.adp.lib.util.t.b(cursor);
                }
            }
        }
        return emotionGroupData;
    }

    public List<EmotionGroupData> dn(int i) {
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase ak = mainDBDatabaseManager.ak();
        Cursor cursor = null;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = ak.rawQuery("SELECT * FROM emotion_group where status = ? ", new String[]{String.valueOf(i)});
            while (cursor.moveToNext()) {
                linkedList.add(e(cursor));
            }
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.a(th, "EmotionsDBManager.listAllEmotionGroups");
            } finally {
                com.baidu.adp.lib.util.t.b(cursor);
            }
        }
        return linkedList;
    }

    protected EmotionGroupData e(Cursor cursor) {
        EmotionGroupData emotionGroupData = new EmotionGroupData();
        emotionGroupData.groupId = cursor.getString(cursor.getColumnIndex("groupId"));
        emotionGroupData.groupName = cursor.getString(cursor.getColumnIndex("groupName"));
        emotionGroupData.groupDesc = cursor.getString(cursor.getColumnIndex("groupDesc"));
        emotionGroupData.emotionsCount = cursor.getInt(cursor.getColumnIndex("emotionsCount"));
        emotionGroupData.width = cursor.getInt(cursor.getColumnIndex("width"));
        emotionGroupData.height = cursor.getInt(cursor.getColumnIndex("height"));
        emotionGroupData.status = cursor.getInt(cursor.getColumnIndex("status"));
        emotionGroupData.downloadTime = cursor.getInt(cursor.getColumnIndex("downloadTime"));
        emotionGroupData.bytesLength = cursor.getInt(cursor.getColumnIndex("bytesLength"));
        emotionGroupData.bytesReceived = cursor.getInt(cursor.getColumnIndex("bytesReceived"));
        emotionGroupData.downloadUrl = cursor.getString(cursor.getColumnIndex("downloadUrl"));
        return emotionGroupData;
    }

    public boolean f(String str, String str2, int i) {
        EmotionData emotionData = new EmotionData();
        emotionData.sharpText = str;
        emotionData.groupId = str2;
        emotionData.orderId = i;
        return a(emotionData);
    }

    public boolean a(EmotionData emotionData) {
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase ak = mainDBDatabaseManager.ak();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sharpText", emotionData.sharpText);
            contentValues.put("groupId", emotionData.groupId);
            contentValues.put("orderId", Integer.valueOf(emotionData.orderId));
            ak.insert("emotions", null, contentValues);
            return true;
        } catch (Throwable th) {
            mainDBDatabaseManager.a(th, "EmotionsDBManager.addEmotion");
            return false;
        }
    }

    public List<EmotionData> dY(String str) {
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase ak = mainDBDatabaseManager.ak();
        Cursor cursor = null;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = ak.rawQuery("SELECT * FROM emotions where groupId = ? order by orderId asc ", new String[]{String.valueOf(str)});
            while (cursor.moveToNext()) {
                linkedList.add(f(cursor));
            }
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.a(th, "EmotionsDBManager.listEmotionByGroup");
            } finally {
                com.baidu.adp.lib.util.t.b(cursor);
            }
        }
        return linkedList;
    }

    protected EmotionData f(Cursor cursor) {
        EmotionData emotionData = new EmotionData();
        emotionData.sharpText = cursor.getString(cursor.getColumnIndex("sharpText"));
        emotionData.groupId = cursor.getString(cursor.getColumnIndex("groupId"));
        emotionData.orderId = cursor.getInt(cursor.getColumnIndex("orderId"));
        return emotionData;
    }

    public boolean a(String str, EmotionGroupData emotionGroupData) {
        if (TextUtils.isEmpty(str) || emotionGroupData == null) {
            return false;
        }
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase ak = mainDBDatabaseManager.ak();
        try {
            ak.delete("user_emotions", "uid = ? and groupId = ?", new String[]{str, emotionGroupData.groupId});
            ContentValues contentValues = new ContentValues();
            contentValues.put(SapiAccountManager.SESSION_UID, str);
            contentValues.put("groupId", emotionGroupData.groupId);
            contentValues.put("updateTime", Long.valueOf(System.currentTimeMillis()));
            ak.insert("user_emotions", null, contentValues);
            return true;
        } catch (Throwable th) {
            mainDBDatabaseManager.a(th, "EmotionsDBManager.addToMyEmotion");
            return false;
        }
    }
}
