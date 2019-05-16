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
    private static h gyo;

    public static h bzX() {
        if (gyo == null) {
            synchronized (h.class) {
                if (gyo == null) {
                    gyo = new h();
                }
            }
        }
        return gyo;
    }

    public void bzY() {
        SQLiteDatabase bzV = g.bzV();
        if (bzV != null) {
            if (bzV.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bzV.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase bzV = g.bzV();
        if (bzV != null) {
            BdLog.i("begin commit transaction");
            if (bzV.inTransaction()) {
                try {
                    bzV.setTransactionSuccessful();
                    bzV.endTransaction();
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
        SQLiteDatabase bzV = g.bzV();
        if (bzV == null) {
            return false;
        }
        try {
            bzV.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase bzV = g.bzV();
        if (bzV == null) {
            return null;
        }
        try {
            return bzV.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bzV = g.bzV();
        if (bzV == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bzV.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bzV = g.bzV();
        if (bzV == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bzV.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase bzV = g.bzV();
        if (bzV == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bzV.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase bzV;
        if (TextUtils.isEmpty(str) || (bzV = g.bzV()) == null) {
            return null;
        }
        try {
            return bzV.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
