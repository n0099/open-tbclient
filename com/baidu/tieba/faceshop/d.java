package com.baidu.tieba.faceshop;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static d a = new d();

    public static d a() {
        return a;
    }

    public int a(String str, InputStream inputStream) {
        com.baidu.tbadk.editortool.u a2 = com.baidu.tbadk.editortool.u.a();
        List<String> a3 = e.a(str, inputStream);
        int i = 0;
        for (int i2 = 0; i2 < a3.size(); i2++) {
            if (a2.a(a3.get(i2), str, i2 + 1)) {
                i++;
            }
        }
        return i;
    }

    public boolean a(MyEmotionGroupData myEmotionGroupData) {
        if (myEmotionGroupData == null) {
            return false;
        }
        com.baidu.adp.base.a.c b = com.baidu.tbadk.j.a().b();
        try {
            b.a().delete("user_emotions", "uid = ? and groupId = ?", new String[]{myEmotionGroupData.uid, myEmotionGroupData.groupId});
            return true;
        } catch (Throwable th) {
            b.a(th, "EmotionsDBManager.deleteMyEmotion");
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
    public MyEmotionGroupData a(String str, String str2) {
        Cursor cursor;
        MyEmotionGroupData myEmotionGroupData = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.baidu.adp.base.a.c b = com.baidu.tbadk.j.a().b();
            try {
                cursor = b.a().rawQuery("SELECT * FROM user_emotions where uid = ? and groupId = ? ", new String[]{str, str2});
                try {
                    if (cursor.moveToNext()) {
                        myEmotionGroupData = a(cursor);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        b.a(th, "EmotionsDBManager.getMyEmotion");
                        return myEmotionGroupData;
                    } finally {
                        com.baidu.adp.lib.util.m.a(cursor);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        }
        return myEmotionGroupData;
    }

    public List<MyEmotionGroupData> a(String str) {
        LinkedList linkedList = new LinkedList();
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.base.a.c b = com.baidu.tbadk.j.a().b();
            Cursor cursor = null;
            try {
                cursor = b.a().rawQuery("SELECT * FROM user_emotions where uid = ? order by updateTime desc ", new String[]{str});
                while (cursor.moveToNext()) {
                    linkedList.add(a(cursor));
                }
            } catch (Throwable th) {
                try {
                    b.a(th, "EmotionsDBManager.listMyEmotions");
                } finally {
                    com.baidu.adp.lib.util.m.a(cursor);
                }
            }
        }
        return linkedList;
    }

    protected MyEmotionGroupData a(Cursor cursor) {
        MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
        myEmotionGroupData.id = cursor.getInt(cursor.getColumnIndex("id"));
        myEmotionGroupData.uid = cursor.getString(cursor.getColumnIndex(SapiAccountManager.SESSION_UID));
        myEmotionGroupData.groupId = cursor.getString(cursor.getColumnIndex("groupId"));
        myEmotionGroupData.updateTime = cursor.getLong(cursor.getColumnIndex("updateTime"));
        return myEmotionGroupData;
    }
}
