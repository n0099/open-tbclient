package com.baidu.tbadk.coreExtra.relationship;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class j {
    private static volatile SQLiteDatabase a;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (j.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else if (a != null && a.isOpen()) {
                sQLiteDatabase = a;
            } else {
                a = new i(TbadkApplication.m252getInst().getApp()).getWritableDatabase();
                sQLiteDatabase = a;
            }
        }
        return sQLiteDatabase;
    }
}
