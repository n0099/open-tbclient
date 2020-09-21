package com.baidu.tieba.addresslist.relationship;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes20.dex */
public class h {
    private static volatile SQLiteDatabase fuM;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void bDi() {
        synchronized (h.class) {
            n.close(fuM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase bDj() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (h.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else if (fuM != null && fuM.isOpen()) {
                sQLiteDatabase = fuM;
            } else {
                fuM = new g(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();
                sQLiteDatabase = fuM;
            }
        }
        return sQLiteDatabase;
    }
}
