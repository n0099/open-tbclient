package com.baidu.tieba.addresslist.relationship;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class i {
    private static volatile SQLiteDatabase sDatabase;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase Fr() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (i.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else if (sDatabase != null && sDatabase.isOpen()) {
                sQLiteDatabase = sDatabase;
            } else {
                sDatabase = new h(TbadkCoreApplication.m411getInst().getApp()).getWritableDatabase();
                sQLiteDatabase = sDatabase;
            }
        }
        return sQLiteDatabase;
    }
}
