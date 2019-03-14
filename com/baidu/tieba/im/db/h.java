package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class h {
    private static h gho;

    public static h bso() {
        if (gho == null) {
            synchronized (h.class) {
                if (gho == null) {
                    gho = new h();
                }
            }
        }
        return gho;
    }

    public void bsp() {
        SQLiteDatabase bsm = g.bsm();
        if (bsm != null) {
            if (bsm.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bsm.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase bsm = g.bsm();
        if (bsm != null) {
            BdLog.i("begin commit transaction");
            if (bsm.inTransaction()) {
                try {
                    bsm.setTransactionSuccessful();
                    bsm.endTransaction();
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

    public boolean wW(String str) {
        SQLiteDatabase bsm = g.bsm();
        if (bsm == null) {
            return false;
        }
        try {
            bsm.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase bsm = g.bsm();
        if (bsm == null) {
            return null;
        }
        try {
            return bsm.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bsm = g.bsm();
        if (bsm == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bsm.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bsm = g.bsm();
        if (bsm == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bsm.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase bsm = g.bsm();
        if (bsm == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bsm.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase bsm;
        if (TextUtils.isEmpty(str) || (bsm = g.bsm()) == null) {
            return null;
        }
        try {
            return bsm.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
