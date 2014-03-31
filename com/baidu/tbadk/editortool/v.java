package com.baidu.tbadk.editortool;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.DatabaseManager;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public final class v {
    private static v a = new v();

    public static v a() {
        return a;
    }

    private v() {
    }

    public static boolean a(EmotionGroupData emotionGroupData) {
        SQLiteDatabase a2 = DatabaseManager.a();
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
            a2.insert("emotion_group", null, contentValues);
            return true;
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b("EmotionsDBManager", "addEmotionGroup", th.getMessage());
            DatabaseManager.a(th, "EmotionsDBManager.addEmotionGroup");
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [123=4] */
    public final EmotionGroupData a(String str) {
        Cursor cursor;
        EmotionGroupData emotionGroupData = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                cursor = DatabaseManager.a().rawQuery("SELECT * FROM emotion_group where groupId = ? ", new String[]{str});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    emotionGroupData = a(cursor);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    com.baidu.adp.lib.util.f.b("EmotionsDBManager", "getEmotionGroup", th.getMessage());
                    DatabaseManager.a(th, "EmotionsDBManager.getEmotionGroup");
                    return emotionGroupData;
                } finally {
                    com.baidu.tbadk.core.util.l.a(cursor);
                }
            }
        }
        return emotionGroupData;
    }

    public final List<EmotionGroupData> a(int i) {
        SQLiteDatabase a2 = DatabaseManager.a();
        Cursor cursor = null;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = a2.rawQuery("SELECT * FROM emotion_group where status = ? ", new String[]{String.valueOf(1)});
            while (cursor.moveToNext()) {
                linkedList.add(a(cursor));
            }
        } catch (Throwable th) {
            try {
                com.baidu.adp.lib.util.f.b("EmotionsDBManager", "listAllEmotionGroups", th.getMessage());
                DatabaseManager.a(th, "EmotionsDBManager.listAllEmotionGroups");
            } finally {
                com.baidu.tbadk.core.util.l.a(cursor);
            }
        }
        return linkedList;
    }

    private static EmotionGroupData a(Cursor cursor) {
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

    public final boolean a(String str, String str2, int i) {
        EmotionData emotionData = new EmotionData();
        emotionData.sharpText = str;
        emotionData.groupId = str2;
        emotionData.orderId = i;
        return a(emotionData);
    }

    private static boolean a(EmotionData emotionData) {
        SQLiteDatabase a2 = DatabaseManager.a();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sharpText", emotionData.sharpText);
            contentValues.put("groupId", emotionData.groupId);
            contentValues.put("orderId", Integer.valueOf(emotionData.orderId));
            a2.insert("emotions", null, contentValues);
            return true;
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b("EmotionsDBManager", "addEmotion", th.getMessage());
            DatabaseManager.a(th, "EmotionsDBManager.addEmotion");
            return false;
        }
    }

    public final List<EmotionData> b(String str) {
        SQLiteDatabase a2 = DatabaseManager.a();
        Cursor cursor = null;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = a2.rawQuery("SELECT * FROM emotions where groupId = ? order by orderId asc ", new String[]{String.valueOf(str)});
            while (cursor.moveToNext()) {
                EmotionData emotionData = new EmotionData();
                emotionData.sharpText = cursor.getString(cursor.getColumnIndex("sharpText"));
                emotionData.groupId = cursor.getString(cursor.getColumnIndex("groupId"));
                emotionData.orderId = cursor.getInt(cursor.getColumnIndex("orderId"));
                linkedList.add(emotionData);
            }
        } catch (Throwable th) {
            try {
                com.baidu.adp.lib.util.f.b("EmotionsDBManager", "listEmotionByGroup", th.getMessage());
                DatabaseManager.a(th, "EmotionsDBManager.listEmotionByGroup");
            } finally {
                com.baidu.tbadk.core.util.l.a(cursor);
            }
        }
        return linkedList;
    }

    public static boolean a(String str, EmotionGroupData emotionGroupData) {
        if (TextUtils.isEmpty(str) || emotionGroupData == null) {
            return false;
        }
        SQLiteDatabase a2 = DatabaseManager.a();
        try {
            a2.delete("user_emotions", "uid = ? and groupId = ?", new String[]{str, emotionGroupData.groupId});
            ContentValues contentValues = new ContentValues();
            contentValues.put("uid", str);
            contentValues.put("groupId", emotionGroupData.groupId);
            contentValues.put("updateTime", Long.valueOf(System.currentTimeMillis()));
            a2.insert("user_emotions", null, contentValues);
            return true;
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b("EmotionsDBManager", "addToMyEmotion", th.getMessage());
            DatabaseManager.a(th, "EmotionsDBManager.addToMyEmotion");
            return false;
        }
    }
}
