package com.baidu.tieba.addresslist.relationship;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes21.dex */
public class h {
    private static volatile SQLiteDatabase gcZ;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void bNo() {
        synchronized (h.class) {
            n.close(gcZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase bNp() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (h.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else if (gcZ != null && gcZ.isOpen()) {
                sQLiteDatabase = gcZ;
            } else {
                gcZ = new g(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();
                sQLiteDatabase = gcZ;
            }
        }
        return sQLiteDatabase;
    }
}
