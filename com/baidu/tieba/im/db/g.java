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
    private static g bcn;

    public static g PO() {
        if (bcn == null) {
            synchronized (g.class) {
                if (bcn == null) {
                    bcn = new g();
                }
            }
        }
        return bcn;
    }

    public void PP() {
        SQLiteDatabase PM = f.PM();
        if (PM != null) {
            if (PM.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                PM.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase PM = f.PM();
        if (PM != null) {
            BdLog.i("begin commit transaction");
            if (PM.inTransaction()) {
                try {
                    PM.setTransactionSuccessful();
                    PM.endTransaction();
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

    public boolean gx(String str) {
        SQLiteDatabase PM = f.PM();
        if (PM == null) {
            return false;
        }
        try {
            PM.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase PM = f.PM();
        if (PM == null) {
            return null;
        }
        try {
            return PM.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase PM = f.PM();
        if (PM == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return PM.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase PM = f.PM();
        if (PM == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return PM.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase PM = f.PM();
        if (PM == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return PM.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase PM;
        if (TextUtils.isEmpty(str) || (PM = f.PM()) == null) {
            return null;
        }
        try {
            return PM.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
