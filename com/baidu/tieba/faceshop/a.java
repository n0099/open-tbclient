package com.baidu.tieba.faceshop;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private static a iSS = new a();

    public static a cyo() {
        return iSS;
    }

    public int b(String str, InputStream inputStream) throws Exception {
        i cyE = i.cyE();
        List<String> c = b.c(str, inputStream);
        int i = 0;
        for (int i2 = 0; i2 < c.size(); i2++) {
            if (cyE.t(c.get(i2), str, i2 + 1)) {
                i++;
            }
        }
        return i;
    }

    public int a(com.baidu.tieba.newfaceshop.b.a aVar) {
        if (aVar == null || aVar.pics == null || aVar.pics.size() == 0) {
            return 0;
        }
        String str = ".emotions/" + aVar.id;
        i cyE = i.cyE();
        List<com.baidu.tieba.newfaceshop.b.b> list = aVar.pics;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.baidu.tieba.newfaceshop.b.b bVar = list.get(i2);
            if (checkFile(str + "/" + bVar.name) && checkFile(str + "/" + bVar.lAy)) {
                StringBuilder sb = new StringBuilder("meme,");
                sb.append(aVar.id + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + bVar.id).append(",");
                sb.append(bVar.width).append(",");
                sb.append(bVar.height).append(",");
                String str2 = "#(" + sb.toString() + com.baidu.adp.lib.util.s.toMd5(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + ")";
                boolean z = com.baidu.tbadk.core.util.o.isGif(str, bVar.name);
                b.aF(aVar.id, bVar.lAy, b.j(str2, true, false));
                b.aF(aVar.id, bVar.name, b.j(str2, false, z));
                if (cyE.t(str2, aVar.id, i2 + 1)) {
                    i++;
                }
            }
        }
        return i;
    }

    private boolean checkFile(String str) {
        return new File(TbadkCoreApplication.getInst().getFilesDir(), str).exists();
    }

    public boolean a(MyEmotionGroupData myEmotionGroupData) {
        if (myEmotionGroupData == null) {
            return false;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            mainDBDatabaseManager.getOpenedDatabase().delete("user_emotions", "uid = ? and groupId = ?", new String[]{myEmotionGroupData.uid, myEmotionGroupData.groupId});
            return true;
        } catch (Throwable th) {
            mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.deleteMyEmotion");
            return false;
        }
    }

    public boolean Jv(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Cursor cursor = null;
        try {
            cursor = mainDBDatabaseManager.getOpenedDatabase().rawQuery("SELECT * FROM user_emotions where uid = ? and groupId = ? ", new String[]{TbadkCoreApplication.getCurrentAccount(), str});
            return cursor.moveToNext();
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.hasEmotionByPckID");
                return false;
            } finally {
                com.baidu.adp.lib.util.n.close(cursor);
            }
        }
    }

    public MyEmotionGroupData eS(String str, String str2) {
        Cursor cursor;
        MyEmotionGroupData myEmotionGroupData = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                cursor = mainDBDatabaseManager.getOpenedDatabase().rawQuery("SELECT * FROM user_emotions where uid = ? and groupId = ? ", new String[]{str, str2});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    myEmotionGroupData = y(cursor);
                    com.baidu.adp.lib.util.n.close(cursor);
                } else {
                    com.baidu.adp.lib.util.n.close(cursor);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.getMyEmotion");
                    com.baidu.adp.lib.util.n.close(cursor);
                    return myEmotionGroupData;
                } catch (Throwable th3) {
                    com.baidu.adp.lib.util.n.close(cursor);
                    throw th3;
                }
            }
        }
        return myEmotionGroupData;
    }

    public List<MyEmotionGroupData> Jw(String str) {
        LinkedList linkedList = new LinkedList();
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            Cursor cursor = null;
            try {
                cursor = mainDBDatabaseManager.getOpenedDatabase().rawQuery("SELECT * FROM user_emotions where uid = ? order by updateTime desc ", new String[]{str});
                while (cursor.moveToNext()) {
                    linkedList.add(y(cursor));
                }
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.notifySQLException(th, "EmotionsDBManager.listMyEmotions");
                } finally {
                    com.baidu.adp.lib.util.n.close(cursor);
                }
            }
        }
        return linkedList;
    }

    protected MyEmotionGroupData y(Cursor cursor) {
        MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
        myEmotionGroupData.id = cursor.getInt(cursor.getColumnIndex("id"));
        myEmotionGroupData.uid = cursor.getString(cursor.getColumnIndex("uid"));
        myEmotionGroupData.groupId = cursor.getString(cursor.getColumnIndex(TbEnum.SystemMessage.KEY_GROUP_ID));
        myEmotionGroupData.updateTime = cursor.getLong(cursor.getColumnIndex("updateTime"));
        return myEmotionGroupData;
    }
}
