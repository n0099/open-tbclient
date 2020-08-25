package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes2.dex */
public class h {
    private static h jmj;

    public static h cEd() {
        if (jmj == null) {
            synchronized (h.class) {
                if (jmj == null) {
                    jmj = new h();
                }
            }
        }
        return jmj;
    }

    public void cEe() {
        SQLiteDatabase cEb = g.cEb();
        if (cEb != null) {
            if (cEb.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cEb.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cEf() {
        SQLiteDatabase cEb = g.cEb();
        if (cEb != null) {
            BdLog.i("begin commit transaction");
            if (cEb.inTransaction()) {
                try {
                    cEb.setTransactionSuccessful();
                    cEb.endTransaction();
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

    public boolean KA(String str) {
        SQLiteDatabase cEb = g.cEb();
        if (cEb == null) {
            return false;
        }
        try {
            cEb.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cEb = g.cEb();
        if (cEb == null) {
            return null;
        }
        try {
            return cEb.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase cEb = g.cEb();
        if (cEb == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cEb.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cEb = g.cEb();
        if (cEb == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cEb.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cEb = g.cEb();
        if (cEb == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cEb.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement KB(String str) {
        SQLiteDatabase cEb;
        if (TextUtils.isEmpty(str) || (cEb = g.cEb()) == null) {
            return null;
        }
        try {
            return cEb.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
