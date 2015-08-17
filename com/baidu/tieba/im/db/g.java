package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class g {
    private static g bsY;

    public static g SZ() {
        if (bsY == null) {
            synchronized (g.class) {
                if (bsY == null) {
                    bsY = new g();
                }
            }
        }
        return bsY;
    }

    public void Ta() {
        SQLiteDatabase SX = f.SX();
        if (SX != null) {
            if (SX.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                SX.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase SX = f.SX();
        if (SX != null) {
            BdLog.i("begin commit transaction");
            if (SX.inTransaction()) {
                try {
                    SX.setTransactionSuccessful();
                    SX.endTransaction();
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

    public boolean hC(String str) {
        SQLiteDatabase SX = f.SX();
        if (SX == null) {
            return false;
        }
        try {
            SX.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase SX = f.SX();
        if (SX == null) {
            return null;
        }
        try {
            return SX.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase SX = f.SX();
        if (SX == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return SX.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase SX = f.SX();
        if (SX == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return SX.update(str, contentValues, str2, strArr);
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

    public long insert(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase SX = f.SX();
        if (SX == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return SX.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase SX;
        if (TextUtils.isEmpty(str) || (SX = f.SX()) == null) {
            return null;
        }
        try {
            return SX.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
