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
    private static g cUF;

    public static g apF() {
        if (cUF == null) {
            synchronized (g.class) {
                if (cUF == null) {
                    cUF = new g();
                }
            }
        }
        return cUF;
    }

    public void apG() {
        SQLiteDatabase apD = f.apD();
        if (apD != null) {
            if (apD.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                apD.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase apD = f.apD();
        if (apD != null) {
            BdLog.i("begin commit transaction");
            if (apD.inTransaction()) {
                try {
                    apD.setTransactionSuccessful();
                    apD.endTransaction();
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

    public boolean km(String str) {
        SQLiteDatabase apD = f.apD();
        if (apD == null) {
            return false;
        }
        try {
            apD.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase apD = f.apD();
        if (apD == null) {
            return null;
        }
        try {
            return apD.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase apD = f.apD();
        if (apD == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return apD.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase apD = f.apD();
        if (apD == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return apD.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase apD = f.apD();
        if (apD == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return apD.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase apD;
        if (TextUtils.isEmpty(str) || (apD = f.apD()) == null) {
            return null;
        }
        try {
            return apD.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
