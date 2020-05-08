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
    private static h ijG;

    public static h cfk() {
        if (ijG == null) {
            synchronized (h.class) {
                if (ijG == null) {
                    ijG = new h();
                }
            }
        }
        return ijG;
    }

    public void cfl() {
        SQLiteDatabase cfi = g.cfi();
        if (cfi != null) {
            if (cfi.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cfi.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cfm() {
        SQLiteDatabase cfi = g.cfi();
        if (cfi != null) {
            BdLog.i("begin commit transaction");
            if (cfi.inTransaction()) {
                try {
                    cfi.setTransactionSuccessful();
                    cfi.endTransaction();
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

    public boolean EJ(String str) {
        SQLiteDatabase cfi = g.cfi();
        if (cfi == null) {
            return false;
        }
        try {
            cfi.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cfi = g.cfi();
        if (cfi == null) {
            return null;
        }
        try {
            return cfi.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase cfi = g.cfi();
        if (cfi == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cfi.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cfi = g.cfi();
        if (cfi == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cfi.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cfi = g.cfi();
        if (cfi == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cfi.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement EK(String str) {
        SQLiteDatabase cfi;
        if (TextUtils.isEmpty(str) || (cfi = g.cfi()) == null) {
            return null;
        }
        try {
            return cfi.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
