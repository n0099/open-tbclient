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
    private static h gFu;

    public static h bCU() {
        if (gFu == null) {
            synchronized (h.class) {
                if (gFu == null) {
                    gFu = new h();
                }
            }
        }
        return gFu;
    }

    public void bCV() {
        SQLiteDatabase bCS = g.bCS();
        if (bCS != null) {
            if (bCS.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bCS.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bCW() {
        SQLiteDatabase bCS = g.bCS();
        if (bCS != null) {
            BdLog.i("begin commit transaction");
            if (bCS.inTransaction()) {
                try {
                    bCS.setTransactionSuccessful();
                    bCS.endTransaction();
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

    public boolean yX(String str) {
        SQLiteDatabase bCS = g.bCS();
        if (bCS == null) {
            return false;
        }
        try {
            bCS.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor b(String str, String[] strArr) {
        SQLiteDatabase bCS = g.bCS();
        if (bCS == null) {
            return null;
        }
        try {
            return bCS.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bCS = g.bCS();
        if (bCS == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bCS.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bCS = g.bCS();
        if (bCS == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bCS.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase bCS = g.bCS();
        if (bCS == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bCS.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement yY(String str) {
        SQLiteDatabase bCS;
        if (TextUtils.isEmpty(str) || (bCS = g.bCS()) == null) {
            return null;
        }
        try {
            return bCS.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
