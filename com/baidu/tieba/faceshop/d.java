package com.baidu.tieba.faceshop;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TiebaDatabase;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static d aso = new d();

    public static d CI() {
        return aso;
    }

    public int a(String str, InputStream inputStream) {
        com.baidu.tbadk.editortool.u ry = com.baidu.tbadk.editortool.u.ry();
        List<String> b = e.b(str, inputStream);
        int i = 0;
        for (int i2 = 0; i2 < b.size(); i2++) {
            if (ry.b(b.get(i2), str, i2 + 1)) {
                i++;
            }
        }
        return i;
    }

    public boolean a(MyEmotionGroupData myEmotionGroupData) {
        if (myEmotionGroupData == null) {
            return false;
        }
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            mainDBDatabaseManager.P().delete("user_emotions", "uid = ? and groupId = ?", new String[]{myEmotionGroupData.uid, myEmotionGroupData.groupId});
            return true;
        } catch (Throwable th) {
            mainDBDatabaseManager.a(th, "EmotionsDBManager.deleteMyEmotion");
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    public MyEmotionGroupData ac(String str, String str2) {
        Cursor cursor;
        MyEmotionGroupData myEmotionGroupData = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                cursor = mainDBDatabaseManager.P().rawQuery("SELECT * FROM user_emotions where uid = ? and groupId = ? ", new String[]{str, str2});
                try {
                    if (cursor.moveToNext()) {
                        myEmotionGroupData = d(cursor);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        mainDBDatabaseManager.a(th, "EmotionsDBManager.getMyEmotion");
                        return myEmotionGroupData;
                    } finally {
                        com.baidu.adp.lib.util.p.a(cursor);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        }
        return myEmotionGroupData;
    }

    public List<MyEmotionGroupData> eJ(String str) {
        LinkedList linkedList = new LinkedList();
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            Cursor cursor = null;
            try {
                cursor = mainDBDatabaseManager.P().rawQuery("SELECT * FROM user_emotions where uid = ? order by updateTime desc ", new String[]{str});
                while (cursor.moveToNext()) {
                    linkedList.add(d(cursor));
                }
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.a(th, "EmotionsDBManager.listMyEmotions");
                } finally {
                    com.baidu.adp.lib.util.p.a(cursor);
                }
            }
        }
        return linkedList;
    }

    protected MyEmotionGroupData d(Cursor cursor) {
        MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
        myEmotionGroupData.id = cursor.getInt(cursor.getColumnIndex("id"));
        myEmotionGroupData.uid = cursor.getString(cursor.getColumnIndex(SapiAccountManager.SESSION_UID));
        myEmotionGroupData.groupId = cursor.getString(cursor.getColumnIndex("groupId"));
        myEmotionGroupData.updateTime = cursor.getLong(cursor.getColumnIndex("updateTime"));
        return myEmotionGroupData;
    }
}
