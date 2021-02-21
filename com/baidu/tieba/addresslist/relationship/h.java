package com.baidu.tieba.addresslist.relationship;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes8.dex */
public class h {
    private static volatile SQLiteDatabase gkk;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void bMq() {
        synchronized (h.class) {
            n.close(gkk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase bMr() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (h.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else if (gkk != null && gkk.isOpen()) {
                sQLiteDatabase = gkk;
            } else {
                gkk = new g(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();
                sQLiteDatabase = gkk;
            }
        }
        return sQLiteDatabase;
    }
}
