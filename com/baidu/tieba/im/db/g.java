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
    private static g cTc;

    public static g apy() {
        if (cTc == null) {
            synchronized (g.class) {
                if (cTc == null) {
                    cTc = new g();
                }
            }
        }
        return cTc;
    }

    public void apz() {
        SQLiteDatabase apw = f.apw();
        if (apw != null) {
            if (apw.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                apw.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase apw = f.apw();
        if (apw != null) {
            BdLog.i("begin commit transaction");
            if (apw.inTransaction()) {
                try {
                    apw.setTransactionSuccessful();
                    apw.endTransaction();
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

    public boolean ks(String str) {
        SQLiteDatabase apw = f.apw();
        if (apw == null) {
            return false;
        }
        try {
            apw.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase apw = f.apw();
        if (apw == null) {
            return null;
        }
        try {
            return apw.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase apw = f.apw();
        if (apw == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return apw.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase apw = f.apw();
        if (apw == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return apw.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase apw = f.apw();
        if (apw == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return apw.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase apw;
        if (TextUtils.isEmpty(str) || (apw = f.apw()) == null) {
            return null;
        }
        try {
            return apw.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
