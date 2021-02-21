package com.baidu.tieba.faceshop;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class i {
    private static i iUO = new i();

    public static i cyL() {
        return iUO;
    }

    private i() {
    }

    public boolean a(EmotionGroupData emotionGroupData) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase openedDatabase = mainDBDatabaseManager.getOpenedDatabase();
        openedDatabase.beginTransaction();
        try {
            openedDatabase.delete("emotion_group", "groupId = ?", new String[]{emotionGroupData.groupId});
            ContentValues contentValues = new ContentValues();
            contentValues.put(TbEnum.SystemMessage.KEY_GROUP_ID, emotionGroupData.groupId);
            contentValues.put(TbEnum.SystemMessage.KEY_GROUP_NAME, emotionGroupData.groupName);
            contentValues.put("groupDesc", emotionGroupData.groupDesc);
            contentValues.put("emotionsCount", Integer.valueOf(emotionGroupData.emotionsCount));
            contentValues.put("width", Integer.valueOf(emotionGroupData.width));
            contentValues.put("height", Integer.valueOf(emotionGroupData.height));
            contentValues.put("status", Integer.valueOf(emotionGroupData.status));
            contentValues.put("downloadTime", Long.valueOf(emotionGroupData.downloadTime));
            contentValues.put("bytesLength", Integer.valueOf(emotionGroupData.bytesLength));
            contentValues.put("bytesReceived", Integer.valueOf(emotionGroupData.bytesReceived));
            contentValues.put("downloadUrl", emotionGroupData.downloadUrl);
            openedDatabase.insert("emotion_group", null, contentValues);
            openedDatabase.setTransactionSuccessful();
            return true;
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.addEmotionGroup");
                return false;
            } finally {
                openedDatabase.endTransaction();
            }
        }
    }

    public EmotionGroupData JD(String str) {
        Cursor cursor;
        EmotionGroupData emotionGroupData = null;
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                cursor = mainDBDatabaseManager.getOpenedDatabase().rawQuery("SELECT * FROM emotion_group where groupId = ? ", new String[]{str});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    emotionGroupData = z(cursor);
                    com.baidu.adp.lib.util.n.close(cursor);
                } else {
                    com.baidu.adp.lib.util.n.close(cursor);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.getEmotionGroup");
                    com.baidu.adp.lib.util.n.close(cursor);
                    return emotionGroupData;
                } catch (Throwable th3) {
                    com.baidu.adp.lib.util.n.close(cursor);
                    throw th3;
                }
            }
        }
        return emotionGroupData;
    }

    public List<EmotionGroupData> xY(int i) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase openedDatabase = mainDBDatabaseManager.getOpenedDatabase();
        Cursor cursor = null;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = openedDatabase.rawQuery("SELECT * FROM emotion_group where status = ? ", new String[]{String.valueOf(i)});
            while (cursor.moveToNext()) {
                linkedList.add(z(cursor));
            }
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.listAllEmotionGroups");
            } finally {
                com.baidu.adp.lib.util.n.close(cursor);
            }
        }
        return linkedList;
    }

    protected EmotionGroupData z(Cursor cursor) {
        EmotionGroupData emotionGroupData = new EmotionGroupData();
        emotionGroupData.groupId = cursor.getString(cursor.getColumnIndex(TbEnum.SystemMessage.KEY_GROUP_ID));
        emotionGroupData.groupName = cursor.getString(cursor.getColumnIndex(TbEnum.SystemMessage.KEY_GROUP_NAME));
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

    public boolean t(String str, String str2, int i) {
        EmotionData emotionData = new EmotionData();
        emotionData.sharpText = str;
        emotionData.groupId = str2;
        emotionData.orderId = i;
        return a(emotionData);
    }

    public boolean a(EmotionData emotionData) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase openedDatabase = mainDBDatabaseManager.getOpenedDatabase();
        openedDatabase.beginTransaction();
        try {
            openedDatabase.delete("emotions", "sharpText = ?", new String[]{emotionData.sharpText});
            ContentValues contentValues = new ContentValues();
            contentValues.put("sharpText", emotionData.sharpText);
            contentValues.put(TbEnum.SystemMessage.KEY_GROUP_ID, emotionData.groupId);
            contentValues.put(CashierData.ORDERID, Integer.valueOf(emotionData.orderId));
            openedDatabase.insert("emotions", null, contentValues);
            openedDatabase.setTransactionSuccessful();
            return true;
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.addEmotion");
                return false;
            } finally {
                openedDatabase.endTransaction();
            }
        }
    }

    public boolean JE(String str) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase openedDatabase = mainDBDatabaseManager.getOpenedDatabase();
        openedDatabase.beginTransaction();
        try {
            openedDatabase.delete("emotions", "groupId = ?", new String[]{str});
            openedDatabase.setTransactionSuccessful();
            return true;
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.deleteEmotion");
                return false;
            } finally {
                openedDatabase.endTransaction();
            }
        }
    }

    public void i(List<String> list, String str) {
        if (list != null && !list.isEmpty()) {
            Collections.reverse(list);
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            SQLiteDatabase openedDatabase = mainDBDatabaseManager.getOpenedDatabase();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Iterator<String> it = list.iterator();
                long j = currentTimeMillis;
                while (it.hasNext()) {
                    ContentValues contentValues = new ContentValues();
                    long j2 = 1 + j;
                    contentValues.put("updateTime", Long.valueOf(j));
                    openedDatabase.update("user_emotions", contentValues, "uid = ? and groupId = ?", new String[]{str, it.next()});
                    j = j2;
                }
            } catch (Throwable th) {
                mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.orderEmotion");
            }
        }
    }

    public List<EmotionData> JF(String str) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase openedDatabase = mainDBDatabaseManager.getOpenedDatabase();
        Cursor cursor = null;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = openedDatabase.rawQuery("SELECT * FROM emotions where groupId = ? order by orderId asc ", new String[]{String.valueOf(str)});
            while (cursor.moveToNext()) {
                linkedList.add(A(cursor));
            }
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.listEmotionByGroup");
            } finally {
                com.baidu.adp.lib.util.n.close(cursor);
            }
        }
        return linkedList;
    }

    protected EmotionData A(Cursor cursor) {
        EmotionData emotionData = new EmotionData();
        emotionData.sharpText = cursor.getString(cursor.getColumnIndex("sharpText"));
        emotionData.groupId = cursor.getString(cursor.getColumnIndex(TbEnum.SystemMessage.KEY_GROUP_ID));
        emotionData.orderId = cursor.getInt(cursor.getColumnIndex(CashierData.ORDERID));
        return emotionData;
    }

    public boolean a(String str, EmotionGroupData emotionGroupData) {
        if (TextUtils.isEmpty(str) || emotionGroupData == null) {
            return false;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase openedDatabase = mainDBDatabaseManager.getOpenedDatabase();
        openedDatabase.beginTransaction();
        try {
            openedDatabase.delete("user_emotions", "uid = ? and groupId = ?", new String[]{str, emotionGroupData.groupId});
            ContentValues contentValues = new ContentValues();
            contentValues.put("uid", str);
            contentValues.put(TbEnum.SystemMessage.KEY_GROUP_ID, emotionGroupData.groupId);
            contentValues.put("updateTime", Long.valueOf(System.currentTimeMillis()));
            openedDatabase.insert("user_emotions", null, contentValues);
            openedDatabase.setTransactionSuccessful();
            return true;
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.addToMyEmotion");
                return false;
            } finally {
                openedDatabase.endTransaction();
            }
        }
    }

    public boolean a(CollectEmotionData collectEmotionData) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase openedDatabase = mainDBDatabaseManager.getOpenedDatabase();
        openedDatabase.beginTransaction();
        try {
            openedDatabase.delete("user_collect_emotion", "uid = ? and pid = ?", new String[]{TbadkCoreApplication.getCurrentAccountForEmotion(), collectEmotionData.pid});
            ContentValues contentValues = new ContentValues();
            contentValues.put("pid", collectEmotionData.pid);
            contentValues.put("uid", collectEmotionData.uid);
            if (!TextUtils.isEmpty(collectEmotionData.sharpText)) {
                contentValues.put("sharp_text", collectEmotionData.sharpText.toLowerCase());
            } else {
                contentValues.put("sharp_text", "");
            }
            contentValues.put("order_id", Integer.valueOf(collectEmotionData.orderId));
            contentValues.put("width", Integer.valueOf(collectEmotionData.width));
            contentValues.put("height", Integer.valueOf(collectEmotionData.height));
            contentValues.put("pic_url", collectEmotionData.picUrl);
            contentValues.put("thumbnail", collectEmotionData.thumbnail);
            contentValues.put(UnitedSchemeConstants.UNITED_SCHEME_BACKUP, collectEmotionData.backup);
            openedDatabase.insert("user_collect_emotion", null, contentValues);
            openedDatabase.setTransactionSuccessful();
            return true;
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.addCollectEmotion");
                return false;
            } finally {
                openedDatabase.endTransaction();
            }
        }
    }

    public boolean cZ(List<CollectEmotionData> list) {
        if (list == null) {
            return false;
        }
        int i = 0;
        for (CollectEmotionData collectEmotionData : list) {
            if (collectEmotionData != null) {
                i = a(collectEmotionData) ? i + 1 : i;
            }
        }
        return i > 0;
    }

    public List<CollectEmotionData> JG(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            Cursor cursor = null;
            try {
                cursor = mainDBDatabaseManager.getOpenedDatabase().rawQuery("SELECT * FROM user_collect_emotion where uid = ? order by order_id desc ", new String[]{str});
                while (cursor.moveToNext()) {
                    CollectEmotionData collectEmotionData = new CollectEmotionData();
                    collectEmotionData.pid = cursor.getString(cursor.getColumnIndex("pid"));
                    collectEmotionData.uid = cursor.getString(cursor.getColumnIndex("uid"));
                    collectEmotionData.sharpText = cursor.getString(cursor.getColumnIndex("sharp_text")).toLowerCase();
                    collectEmotionData.orderId = cursor.getInt(cursor.getColumnIndex("order_id"));
                    collectEmotionData.width = cursor.getInt(cursor.getColumnIndex("width"));
                    collectEmotionData.height = cursor.getInt(cursor.getColumnIndex("height"));
                    collectEmotionData.picUrl = cursor.getString(cursor.getColumnIndex("pic_url"));
                    collectEmotionData.thumbnail = cursor.getString(cursor.getColumnIndex("thumbnail"));
                    collectEmotionData.backup = cursor.getString(cursor.getColumnIndex(UnitedSchemeConstants.UNITED_SCHEME_BACKUP));
                    collectEmotionData.groupId = "collect_" + collectEmotionData.uid;
                    arrayList.add(collectEmotionData);
                }
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.listMyCollectEmotion");
                } finally {
                    com.baidu.adp.lib.util.n.close(cursor);
                }
            }
        }
        return arrayList;
    }

    public int JH(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            Cursor cursor = null;
            try {
                cursor = mainDBDatabaseManager.getOpenedDatabase().rawQuery("SELECT count(*) FROM user_collect_emotion where uid = ? order by order_id asc ", new String[]{str});
                i = 1;
                while (cursor.moveToNext()) {
                    try {
                        i = cursor.getInt(0);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.getCurCollectNum");
                            return i;
                        } finally {
                            com.baidu.adp.lib.util.n.close(cursor);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                i = 1;
            }
        }
        return i;
    }

    public void b(CollectEmotionData collectEmotionData) {
        if (collectEmotionData != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                mainDBDatabaseManager.getOpenedDatabase().delete("user_collect_emotion", "pid = ? and uid = ? ", new String[]{collectEmotionData.pid, collectEmotionData.uid});
            } catch (Throwable th) {
                mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.deleteCurCollect");
            }
        }
    }

    public void c(CollectEmotionData collectEmotionData) {
        if (collectEmotionData != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            SQLiteDatabase openedDatabase = mainDBDatabaseManager.getOpenedDatabase();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("order_id", Integer.valueOf(collectEmotionData.orderId));
                openedDatabase.update("user_collect_emotion", contentValues, "uid = ? and pid = ?", new String[]{collectEmotionData.uid, collectEmotionData.pid});
            } catch (Throwable th) {
                mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.updateCollect");
            }
        }
    }
}
