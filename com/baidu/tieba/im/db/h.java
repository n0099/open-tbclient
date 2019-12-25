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
    private static h hsw;

    public static h bRG() {
        if (hsw == null) {
            synchronized (h.class) {
                if (hsw == null) {
                    hsw = new h();
                }
            }
        }
        return hsw;
    }

    public void bRH() {
        SQLiteDatabase bRE = g.bRE();
        if (bRE != null) {
            if (bRE.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bRE.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bRI() {
        SQLiteDatabase bRE = g.bRE();
        if (bRE != null) {
            BdLog.i("begin commit transaction");
            if (bRE.inTransaction()) {
                try {
                    bRE.setTransactionSuccessful();
                    bRE.endTransaction();
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

    public boolean Cx(String str) {
        SQLiteDatabase bRE = g.bRE();
        if (bRE == null) {
            return false;
        }
        try {
            bRE.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase bRE = g.bRE();
        if (bRE == null) {
            return null;
        }
        try {
            return bRE.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bRE = g.bRE();
        if (bRE == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bRE.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bRE = g.bRE();
        if (bRE == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bRE.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase bRE = g.bRE();
        if (bRE == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bRE.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement Cy(String str) {
        SQLiteDatabase bRE;
        if (TextUtils.isEmpty(str) || (bRE = g.bRE()) == null) {
            return null;
        }
        try {
            return bRE.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
