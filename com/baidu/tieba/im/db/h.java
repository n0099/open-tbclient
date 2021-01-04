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

    public static h cXs() {
        if (kBr == null) {
            synchronized (h.class) {
                if (kBr == null) {
                    kBr = new h();
                }
            }
        }
        return kBr;
    }

    public void cXt() {
        SQLiteDatabase cXq = g.cXq();
        if (cXq != null) {
            if (cXq.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cXq.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cXu() {
        SQLiteDatabase cXq = g.cXq();
        if (cXq != null) {
            BdLog.i("begin commit transaction");
            if (cXq.inTransaction()) {
                try {
                    cXq.setTransactionSuccessful();
                    cXq.endTransaction();
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

    public boolean Nk(String str) {
        SQLiteDatabase cXq = g.cXq();
        if (cXq == null) {
            return false;
        }
        try {
            cXq.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cXq = g.cXq();
        if (cXq == null) {
            return null;
        }
        try {
            return cXq.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean b(String str, String str2, String[] strArr) {
        SQLiteDatabase cXq = g.cXq();
        if (cXq == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cXq.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int b(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cXq = g.cXq();
        if (cXq == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cXq.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cXq = g.cXq();
        if (cXq == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cXq.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement Nl(String str) {
        SQLiteDatabase cXq;
        if (TextUtils.isEmpty(str) || (cXq = g.cXq()) == null) {
            return null;
        }
        try {
            return cXq.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
