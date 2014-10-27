package com.baidu.tbadk.coreExtra.relationship;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class k {
    private static volatile SQLiteDatabase Mt;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase pE() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (k.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else if (Mt != null && Mt.isOpen()) {
                sQLiteDatabase = Mt;
            } else {
                Mt = new j(TbadkApplication.m251getInst().getApp()).getWritableDatabase();
                sQLiteDatabase = Mt;
            }
        }
        return sQLiteDatabase;
    }
}
