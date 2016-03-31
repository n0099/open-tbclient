package com.baidu.tbadk.coreExtra.c;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class b {
    private static volatile SQLiteDatabase akJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase zk() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (b.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GameDbHelper.getGameDataBase", new Object[0]);
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else if (akJ != null && akJ.isOpen()) {
                sQLiteDatabase = akJ;
            } else {
                akJ = new a(TbadkApplication.getInst().getApp()).getWritableDatabase();
                sQLiteDatabase = akJ;
            }
        }
        return sQLiteDatabase;
    }
}
