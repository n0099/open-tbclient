package com.baidu.tieba.addresslist.relationship;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class h {
    private static volatile SQLiteDatabase aix;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void HN() {
        synchronized (h.class) {
            o.h(aix);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase HO() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (h.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else if (aix != null && aix.isOpen()) {
                sQLiteDatabase = aix;
            } else {
                aix = new g(TbadkCoreApplication.m411getInst().getApp()).getWritableDatabase();
                sQLiteDatabase = aix;
            }
        }
        return sQLiteDatabase;
    }
}
