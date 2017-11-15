package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class g {
    private static g dAu;

    public static g axM() {
        if (dAu == null) {
            synchronized (g.class) {
                if (dAu == null) {
                    dAu = new g();
                }
            }
        }
        return dAu;
    }

    public void axN() {
        SQLiteDatabase axK = f.axK();
        if (axK != null) {
            if (axK.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                axK.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase axK = f.axK();
        if (axK != null) {
            BdLog.i("begin commit transaction");
            if (axK.inTransaction()) {
                try {
                    axK.setTransactionSuccessful();
                    axK.endTransaction();
                    return;
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "endTransaction", new Object[0]);
                    BdLog.e(e.getMessage());
                    return;
                }
            }
            BdLog.e("there is no current transaction");
        }
    }

    public boolean mC(String str) {
        SQLiteDatabase axK = f.axK();
        if (axK == null) {
            return false;
        }
        try {
            axK.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase axK = f.axK();
        if (axK == null) {
            return null;
        }
        try {
            return axK.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase axK = f.axK();
        if (axK == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return axK.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase axK = f.axK();
        if (axK == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return axK.update(str, contentValues, str2, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1;
        }
    }

    public long b(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return -1L;
        }
        try {
            return sQLiteStatement.executeInsert();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase axK = f.axK();
        if (axK == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return axK.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase axK;
        if (TextUtils.isEmpty(str) || (axK = f.axK()) == null) {
            return null;
        }
        try {
            return axK.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
