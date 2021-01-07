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
    private static h kBr;

    public static h cXt() {
        if (kBr == null) {
            synchronized (h.class) {
                if (kBr == null) {
                    kBr = new h();
                }
            }
        }
        return kBr;
    }

    public void cXu() {
        SQLiteDatabase cXr = g.cXr();
        if (cXr != null) {
            if (cXr.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cXr.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cXv() {
        SQLiteDatabase cXr = g.cXr();
        if (cXr != null) {
            BdLog.i("begin commit transaction");
            if (cXr.inTransaction()) {
                try {
                    cXr.setTransactionSuccessful();
                    cXr.endTransaction();
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

    public boolean Nj(String str) {
        SQLiteDatabase cXr = g.cXr();
        if (cXr == null) {
            return false;
        }
        try {
            cXr.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cXr = g.cXr();
        if (cXr == null) {
            return null;
        }
        try {
            return cXr.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean b(String str, String str2, String[] strArr) {
        SQLiteDatabase cXr = g.cXr();
        if (cXr == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cXr.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int b(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cXr = g.cXr();
        if (cXr == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cXr.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cXr = g.cXr();
        if (cXr == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cXr.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement Nk(String str) {
        SQLiteDatabase cXr;
        if (TextUtils.isEmpty(str) || (cXr = g.cXr()) == null) {
            return null;
        }
        try {
            return cXr.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
