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
    private static g cKG;

    public static g amK() {
        if (cKG == null) {
            synchronized (g.class) {
                if (cKG == null) {
                    cKG = new g();
                }
            }
        }
        return cKG;
    }

    public void amL() {
        SQLiteDatabase amI = f.amI();
        if (amI != null) {
            if (amI.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                amI.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase amI = f.amI();
        if (amI != null) {
            BdLog.i("begin commit transaction");
            if (amI.inTransaction()) {
                try {
                    amI.setTransactionSuccessful();
                    amI.endTransaction();
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

    public boolean kE(String str) {
        SQLiteDatabase amI = f.amI();
        if (amI == null) {
            return false;
        }
        try {
            amI.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase amI = f.amI();
        if (amI == null) {
            return null;
        }
        try {
            return amI.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase amI = f.amI();
        if (amI == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return amI.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase amI = f.amI();
        if (amI == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return amI.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase amI = f.amI();
        if (amI == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return amI.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase amI;
        if (TextUtils.isEmpty(str) || (amI = f.amI()) == null) {
            return null;
        }
        try {
            return amI.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
