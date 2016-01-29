package com.baidu.tbadk.coreExtra.c;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class b {
    private static volatile SQLiteDatabase aks;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase yI() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (b.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GameDbHelper.getGameDataBase", new Object[0]);
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else if (aks != null && aks.isOpen()) {
                sQLiteDatabase = aks;
            } else {
                aks = new a(TbadkApplication.getInst().getApp()).getWritableDatabase();
                sQLiteDatabase = aks;
            }
        }
        return sQLiteDatabase;
    }
}
