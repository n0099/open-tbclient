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
    private static h gyp;

    public static h bAa() {
        if (gyp == null) {
            synchronized (h.class) {
                if (gyp == null) {
                    gyp = new h();
                }
            }
        }
        return gyp;
    }

    public void bAb() {
        SQLiteDatabase bzY = g.bzY();
        if (bzY != null) {
            if (bzY.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bzY.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase bzY = g.bzY();
        if (bzY != null) {
            BdLog.i("begin commit transaction");
            if (bzY.inTransaction()) {
                try {
                    bzY.setTransactionSuccessful();
                    bzY.endTransaction();
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

    public boolean yk(String str) {
        SQLiteDatabase bzY = g.bzY();
        if (bzY == null) {
            return false;
        }
        try {
            bzY.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase bzY = g.bzY();
        if (bzY == null) {
            return null;
        }
        try {
            return bzY.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bzY = g.bzY();
        if (bzY == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bzY.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bzY = g.bzY();
        if (bzY == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bzY.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase bzY = g.bzY();
        if (bzY == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bzY.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase bzY;
        if (TextUtils.isEmpty(str) || (bzY = g.bzY()) == null) {
            return null;
        }
        try {
            return bzY.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
