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
    private static h kHi;

    public static h cVN() {
        if (kHi == null) {
            synchronized (h.class) {
                if (kHi == null) {
                    kHi = new h();
                }
            }
        }
        return kHi;
    }

    public void cVO() {
        SQLiteDatabase cVL = g.cVL();
        if (cVL != null) {
            if (cVL.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cVL.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cVP() {
        SQLiteDatabase cVL = g.cVL();
        if (cVL != null) {
            BdLog.i("begin commit transaction");
            if (cVL.inTransaction()) {
                try {
                    cVL.setTransactionSuccessful();
                    cVL.endTransaction();
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

    public boolean MX(String str) {
        SQLiteDatabase cVL = g.cVL();
        if (cVL == null) {
            return false;
        }
        try {
            cVL.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cVL = g.cVL();
        if (cVL == null) {
            return null;
        }
        try {
            return cVL.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean b(String str, String str2, String[] strArr) {
        SQLiteDatabase cVL = g.cVL();
        if (cVL == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cVL.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int b(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cVL = g.cVL();
        if (cVL == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cVL.update(str, contentValues, str2, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1;
        }
    }

    public long a(SQLiteStatement sQLiteStatement) {
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

    public long b(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase cVL = g.cVL();
        if (cVL == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cVL.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement MY(String str) {
        SQLiteDatabase cVL;
        if (TextUtils.isEmpty(str) || (cVL = g.cVL()) == null) {
            return null;
        }
        try {
            return cVL.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
