package com.baidu.tieba.addresslist.relationship;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes8.dex */
public class h {
    private static volatile SQLiteDatabase gmq;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void bPG() {
        synchronized (h.class) {
            n.close(gmq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase bPH() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (h.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else if (gmq != null && gmq.isOpen()) {
                sQLiteDatabase = gmq;
            } else {
                gmq = new g(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();
                sQLiteDatabase = gmq;
            }
        }
        return sQLiteDatabase;
    }
}
