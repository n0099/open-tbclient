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
    private static h jWp;

    public static h cOA() {
        if (jWp == null) {
            synchronized (h.class) {
                if (jWp == null) {
                    jWp = new h();
                }
            }
        }
        return jWp;
    }

    public void cOB() {
        SQLiteDatabase cOy = g.cOy();
        if (cOy != null) {
            if (cOy.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cOy.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cOC() {
        SQLiteDatabase cOy = g.cOy();
        if (cOy != null) {
            BdLog.i("begin commit transaction");
            if (cOy.inTransaction()) {
                try {
                    cOy.setTransactionSuccessful();
                    cOy.endTransaction();
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

    public boolean Mq(String str) {
        SQLiteDatabase cOy = g.cOy();
        if (cOy == null) {
            return false;
        }
        try {
            cOy.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cOy = g.cOy();
        if (cOy == null) {
            return null;
        }
        try {
            return cOy.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase cOy = g.cOy();
        if (cOy == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cOy.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cOy = g.cOy();
        if (cOy == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cOy.update(str, contentValues, str2, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1;
        }
    }

    public long a(SQLiteStatement sQLiteStatement) {
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
        SQLiteDatabase cOy = g.cOy();
        if (cOy == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cOy.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement Mr(String str) {
        SQLiteDatabase cOy;
        if (TextUtils.isEmpty(str) || (cOy = g.cOy()) == null) {
            return null;
        }
        try {
            return cOy.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
