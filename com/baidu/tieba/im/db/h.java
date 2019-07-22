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
    private static h gEC;

    public static h bCG() {
        if (gEC == null) {
            synchronized (h.class) {
                if (gEC == null) {
                    gEC = new h();
                }
            }
        }
        return gEC;
    }

    public void bCH() {
        SQLiteDatabase bCE = g.bCE();
        if (bCE != null) {
            if (bCE.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bCE.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bCI() {
        SQLiteDatabase bCE = g.bCE();
        if (bCE != null) {
            BdLog.i("begin commit transaction");
            if (bCE.inTransaction()) {
                try {
                    bCE.setTransactionSuccessful();
                    bCE.endTransaction();
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

    public boolean yW(String str) {
        SQLiteDatabase bCE = g.bCE();
        if (bCE == null) {
            return false;
        }
        try {
            bCE.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor b(String str, String[] strArr) {
        SQLiteDatabase bCE = g.bCE();
        if (bCE == null) {
            return null;
        }
        try {
            return bCE.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bCE = g.bCE();
        if (bCE == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bCE.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bCE = g.bCE();
        if (bCE == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bCE.update(str, contentValues, str2, strArr);
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

    public long a(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase bCE = g.bCE();
        if (bCE == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bCE.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement yX(String str) {
        SQLiteDatabase bCE;
        if (TextUtils.isEmpty(str) || (bCE = g.bCE()) == null) {
            return null;
        }
        try {
            return bCE.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
