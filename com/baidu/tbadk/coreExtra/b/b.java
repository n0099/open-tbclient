package com.baidu.tbadk.coreExtra.b;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class b {
    private static volatile SQLiteDatabase ahI;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase wW() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (b.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GameDbHelper.getGameDataBase", new Object[0]);
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else if (ahI != null && ahI.isOpen()) {
                sQLiteDatabase = ahI;
            } else {
                ahI = new a(TbadkApplication.getInst().getApp()).getWritableDatabase();
                sQLiteDatabase = ahI;
            }
        }
        return sQLiteDatabase;
    }
}
