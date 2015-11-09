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
    private static g bxp;

    public static g Ua() {
        if (bxp == null) {
            synchronized (g.class) {
                if (bxp == null) {
                    bxp = new g();
                }
            }
        }
        return bxp;
    }

    public void Ub() {
        SQLiteDatabase TY = f.TY();
        if (TY != null) {
            if (TY.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                TY.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase TY = f.TY();
        if (TY != null) {
            BdLog.i("begin commit transaction");
            if (TY.inTransaction()) {
                try {
                    TY.setTransactionSuccessful();
                    TY.endTransaction();
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

    public boolean hR(String str) {
        SQLiteDatabase TY = f.TY();
        if (TY == null) {
            return false;
        }
        try {
            TY.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase TY = f.TY();
        if (TY == null) {
            return null;
        }
        try {
            return TY.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase TY = f.TY();
        if (TY == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return TY.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase TY = f.TY();
        if (TY == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return TY.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase TY = f.TY();
        if (TY == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return TY.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase TY;
        if (TextUtils.isEmpty(str) || (TY = f.TY()) == null) {
            return null;
        }
        try {
            return TY.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
