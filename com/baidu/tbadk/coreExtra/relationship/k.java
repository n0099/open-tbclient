package com.baidu.tbadk.coreExtra.relationship;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class k {
    private static volatile SQLiteDatabase Mw;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase pG() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (k.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else if (Mw != null && Mw.isOpen()) {
                sQLiteDatabase = Mw;
            } else {
                Mw = new j(TbadkApplication.m251getInst().getApp()).getWritableDatabase();
                sQLiteDatabase = Mw;
            }
        }
        return sQLiteDatabase;
    }
}
