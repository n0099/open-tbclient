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
    private static h jJQ;

    public static h cLt() {
        if (jJQ == null) {
            synchronized (h.class) {
                if (jJQ == null) {
                    jJQ = new h();
                }
            }
        }
        return jJQ;
    }

    public void cLu() {
        SQLiteDatabase cLr = g.cLr();
        if (cLr != null) {
            if (cLr.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cLr.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cLv() {
        SQLiteDatabase cLr = g.cLr();
        if (cLr != null) {
            BdLog.i("begin commit transaction");
            if (cLr.inTransaction()) {
                try {
                    cLr.setTransactionSuccessful();
                    cLr.endTransaction();
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

    public boolean LS(String str) {
        SQLiteDatabase cLr = g.cLr();
        if (cLr == null) {
            return false;
        }
        try {
            cLr.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cLr = g.cLr();
        if (cLr == null) {
            return null;
        }
        try {
            return cLr.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase cLr = g.cLr();
        if (cLr == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cLr.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cLr = g.cLr();
        if (cLr == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cLr.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cLr = g.cLr();
        if (cLr == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cLr.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement LT(String str) {
        SQLiteDatabase cLr;
        if (TextUtils.isEmpty(str) || (cLr = g.cLr()) == null) {
            return null;
        }
        try {
            return cLr.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
