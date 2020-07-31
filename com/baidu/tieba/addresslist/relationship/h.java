package com.baidu.tieba.addresslist.relationship;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes15.dex */
public class h {
    private static volatile SQLiteDatabase fgb;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void bsZ() {
        synchronized (h.class) {
            n.close(fgb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase bta() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (h.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else if (fgb != null && fgb.isOpen()) {
                sQLiteDatabase = fgb;
            } else {
                fgb = new g(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();
                sQLiteDatabase = fgb;
            }
        }
        return sQLiteDatabase;
    }
}
