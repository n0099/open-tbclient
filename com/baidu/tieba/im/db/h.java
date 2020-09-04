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
    private static h jmq;

    public static h cEe() {
        if (jmq == null) {
            synchronized (h.class) {
                if (jmq == null) {
                    jmq = new h();
                }
            }
        }
        return jmq;
    }

    public void cEf() {
        SQLiteDatabase cEc = g.cEc();
        if (cEc != null) {
            if (cEc.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cEc.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cEg() {
        SQLiteDatabase cEc = g.cEc();
        if (cEc != null) {
            BdLog.i("begin commit transaction");
            if (cEc.inTransaction()) {
                try {
                    cEc.setTransactionSuccessful();
                    cEc.endTransaction();
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

    public boolean KB(String str) {
        SQLiteDatabase cEc = g.cEc();
        if (cEc == null) {
            return false;
        }
        try {
            cEc.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cEc = g.cEc();
        if (cEc == null) {
            return null;
        }
        try {
            return cEc.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase cEc = g.cEc();
        if (cEc == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cEc.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cEc = g.cEc();
        if (cEc == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cEc.update(str, contentValues, str2, strArr);
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

    public long a(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase cEc = g.cEc();
        if (cEc == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cEc.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement KC(String str) {
        SQLiteDatabase cEc;
        if (TextUtils.isEmpty(str) || (cEc = g.cEc()) == null) {
            return null;
        }
        try {
            return cEc.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
