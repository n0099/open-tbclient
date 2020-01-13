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
    private static h hvZ;

    public static h bSP() {
        if (hvZ == null) {
            synchronized (h.class) {
                if (hvZ == null) {
                    hvZ = new h();
                }
            }
        }
        return hvZ;
    }

    public void bSQ() {
        SQLiteDatabase bSN = g.bSN();
        if (bSN != null) {
            if (bSN.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bSN.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bSR() {
        SQLiteDatabase bSN = g.bSN();
        if (bSN != null) {
            BdLog.i("begin commit transaction");
            if (bSN.inTransaction()) {
                try {
                    bSN.setTransactionSuccessful();
                    bSN.endTransaction();
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

    public boolean CH(String str) {
        SQLiteDatabase bSN = g.bSN();
        if (bSN == null) {
            return false;
        }
        try {
            bSN.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase bSN = g.bSN();
        if (bSN == null) {
            return null;
        }
        try {
            return bSN.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bSN = g.bSN();
        if (bSN == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bSN.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bSN = g.bSN();
        if (bSN == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bSN.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase bSN = g.bSN();
        if (bSN == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bSN.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement CI(String str) {
        SQLiteDatabase bSN;
        if (TextUtils.isEmpty(str) || (bSN = g.bSN()) == null) {
            return null;
        }
        try {
            return bSN.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
