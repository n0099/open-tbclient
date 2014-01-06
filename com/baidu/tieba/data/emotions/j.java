package com.baidu.tieba.data.emotions;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bo;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j {
    private static j a = new j();

    public static j a() {
        return a;
    }

    private j() {
    }

    public boolean a(EmotionGroupData emotionGroupData) {
        SQLiteDatabase a2 = DatabaseService.a();
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
            bo.b("EmotionsDBManager", "addEmotionGroup", th.getMessage());
            DatabaseService.a(th);
            return false;
        }
    }

    public EmotionGroupData a(String str) {
        Cursor cursor;
        EmotionGroupData emotionGroupData = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                cursor = DatabaseService.a().rawQuery("SELECT * FROM emotion_group where groupId = ? ", new String[]{str});
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
                    bo.b("EmotionsDBManager", "getEmotionGroup", th.getMessage());
                    DatabaseService.a(th);
                    return emotionGroupData;
                } finally {
                    com.baidu.tieba.util.o.a(cursor);
                }
            }
        }
        return emotionGroupData;
    }

    public List<EmotionGroupData> a(int i) {
        SQLiteDatabase a2 = DatabaseService.a();
        Cursor cursor = null;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = a2.rawQuery("SELECT * FROM emotion_group where status = ? ", new String[]{String.valueOf(i)});
            while (cursor.moveToNext()) {
                linkedList.add(a(cursor));
            }
        } catch (Throwable th) {
            try {
                bo.b("EmotionsDBManager", "listAllEmotionGroups", th.getMessage());
                DatabaseService.a(th);
            } finally {
                com.baidu.tieba.util.o.a(cursor);
            }
        }
        return linkedList;
    }

    protected EmotionGroupData a(Cursor cursor) {
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

    public boolean a(String str, String str2, int i) {
        EmotionData emotionData = new EmotionData();
        emotionData.sharpText = str;
        emotionData.groupId = str2;
        emotionData.orderId = i;
        return a(emotionData);
    }

    public boolean a(EmotionData emotionData) {
        SQLiteDatabase a2 = DatabaseService.a();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sharpText", emotionData.sharpText);
            contentValues.put("groupId", emotionData.groupId);
            contentValues.put("orderId", Integer.valueOf(emotionData.orderId));
            a2.insert("emotions", null, contentValues);
            return true;
        } catch (Throwable th) {
            bo.b("EmotionsDBManager", "addEmotion", th.getMessage());
            DatabaseService.a(th);
            return false;
        }
    }

    public List<EmotionData> b(String str) {
        SQLiteDatabase a2 = DatabaseService.a();
        Cursor cursor = null;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = a2.rawQuery("SELECT * FROM emotions where groupId = ? order by orderId asc ", new String[]{String.valueOf(str)});
            while (cursor.moveToNext()) {
                linkedList.add(b(cursor));
            }
        } catch (Throwable th) {
            try {
                bo.b("EmotionsDBManager", "listEmotionByGroup", th.getMessage());
                DatabaseService.a(th);
            } finally {
                com.baidu.tieba.util.o.a(cursor);
            }
        }
        return linkedList;
    }

    protected EmotionData b(Cursor cursor) {
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
        SQLiteDatabase a2 = DatabaseService.a();
        try {
            a2.delete("user_emotions", "uid = ? and groupId = ?", new String[]{str, emotionGroupData.groupId});
            ContentValues contentValues = new ContentValues();
            contentValues.put("uid", str);
            contentValues.put("groupId", emotionGroupData.groupId);
            contentValues.put("updateTime", Long.valueOf(System.currentTimeMillis()));
            a2.insert("user_emotions", null, contentValues);
            return true;
        } catch (Throwable th) {
            bo.b("EmotionsDBManager", "addToMyEmotion", th.getMessage());
            DatabaseService.a(th);
            return false;
        }
    }

    public boolean a(MyEmotionGroupData myEmotionGroupData) {
        if (myEmotionGroupData == null) {
            return false;
        }
        try {
            DatabaseService.a().delete("user_emotions", "uid = ? and groupId = ?", new String[]{myEmotionGroupData.uid, myEmotionGroupData.groupId});
            return true;
        } catch (Throwable th) {
            bo.b("EmotionsDBManager", "addToMyEmotion", th.getMessage());
            DatabaseService.a(th);
            return false;
        }
    }

    public MyEmotionGroupData a(String str, String str2) {
        Cursor cursor;
        MyEmotionGroupData myEmotionGroupData = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                cursor = DatabaseService.a().rawQuery("SELECT * FROM user_emotions where uid = ? and groupId = ? ", new String[]{str, str2});
                try {
                    if (cursor.moveToNext()) {
                        myEmotionGroupData = c(cursor);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        bo.b("EmotionsDBManager", "getMyEmotion", th.getMessage());
                        DatabaseService.a(th);
                        return myEmotionGroupData;
                    } finally {
                        com.baidu.tieba.util.o.a(cursor);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        }
        return myEmotionGroupData;
    }

    public List<MyEmotionGroupData> c(String str) {
        LinkedList linkedList = new LinkedList();
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = DatabaseService.a().rawQuery("SELECT * FROM user_emotions where uid = ? order by updateTime desc ", new String[]{str});
                while (cursor.moveToNext()) {
                    linkedList.add(c(cursor));
                }
            } catch (Throwable th) {
                try {
                    bo.b("EmotionsDBManager", "listMyEmotions", th.getMessage());
                    DatabaseService.a(th);
                } finally {
                    com.baidu.tieba.util.o.a(cursor);
                }
            }
        }
        return linkedList;
    }

    protected MyEmotionGroupData c(Cursor cursor) {
        MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
        myEmotionGroupData.id = cursor.getInt(cursor.getColumnIndex("id"));
        myEmotionGroupData.uid = cursor.getString(cursor.getColumnIndex("uid"));
        myEmotionGroupData.groupId = cursor.getString(cursor.getColumnIndex("groupId"));
        myEmotionGroupData.updateTime = cursor.getLong(cursor.getColumnIndex("updateTime"));
        return myEmotionGroupData;
    }

    public int a(String str, InputStream inputStream) {
        j a2 = a();
        List<String> a3 = d.a(str, inputStream);
        int i = 0;
        for (int i2 = 0; i2 < a3.size(); i2++) {
            if (a2.a(a3.get(i2), str, i2 + 1)) {
                i++;
            }
        }
        return i;
    }
}
