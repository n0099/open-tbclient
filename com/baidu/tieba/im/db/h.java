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
    private static h kES;

    public static h cVz() {
        if (kES == null) {
            synchronized (h.class) {
                if (kES == null) {
                    kES = new h();
                }
            }
        }
        return kES;
    }

    public void cVA() {
        SQLiteDatabase cVx = g.cVx();
        if (cVx != null) {
            if (cVx.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cVx.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cVB() {
        SQLiteDatabase cVx = g.cVx();
        if (cVx != null) {
            BdLog.i("begin commit transaction");
            if (cVx.inTransaction()) {
                try {
                    cVx.setTransactionSuccessful();
                    cVx.endTransaction();
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

    public boolean MQ(String str) {
        SQLiteDatabase cVx = g.cVx();
        if (cVx == null) {
            return false;
        }
        try {
            cVx.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cVx = g.cVx();
        if (cVx == null) {
            return null;
        }
        try {
            return cVx.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean b(String str, String str2, String[] strArr) {
        SQLiteDatabase cVx = g.cVx();
        if (cVx == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cVx.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int b(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cVx = g.cVx();
        if (cVx == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cVx.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cVx = g.cVx();
        if (cVx == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cVx.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement MR(String str) {
        SQLiteDatabase cVx;
        if (TextUtils.isEmpty(str) || (cVx = g.cVx()) == null) {
            return null;
        }
        try {
            return cVx.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
