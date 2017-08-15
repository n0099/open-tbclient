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
    private static g doL;

    public static g auC() {
        if (doL == null) {
            synchronized (g.class) {
                if (doL == null) {
                    doL = new g();
                }
            }
        }
        return doL;
    }

    public void auD() {
        SQLiteDatabase auA = f.auA();
        if (auA != null) {
            if (auA.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                auA.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase auA = f.auA();
        if (auA != null) {
            BdLog.i("begin commit transaction");
            if (auA.inTransaction()) {
                try {
                    auA.setTransactionSuccessful();
                    auA.endTransaction();
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

    public boolean md(String str) {
        SQLiteDatabase auA = f.auA();
        if (auA == null) {
            return false;
        }
        try {
            auA.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase auA = f.auA();
        if (auA == null) {
            return null;
        }
        try {
            return auA.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase auA = f.auA();
        if (auA == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return auA.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase auA = f.auA();
        if (auA == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return auA.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase auA = f.auA();
        if (auA == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return auA.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase auA;
        if (TextUtils.isEmpty(str) || (auA = f.auA()) == null) {
            return null;
        }
        try {
            return auA.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
