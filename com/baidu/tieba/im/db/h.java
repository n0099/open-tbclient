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
    private static h ghp;

    public static h bsp() {
        if (ghp == null) {
            synchronized (h.class) {
                if (ghp == null) {
                    ghp = new h();
                }
            }
        }
        return ghp;
    }

    public void bsq() {
        SQLiteDatabase bsn = g.bsn();
        if (bsn != null) {
            if (bsn.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bsn.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase bsn = g.bsn();
        if (bsn != null) {
            BdLog.i("begin commit transaction");
            if (bsn.inTransaction()) {
                try {
                    bsn.setTransactionSuccessful();
                    bsn.endTransaction();
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

    public boolean wY(String str) {
        SQLiteDatabase bsn = g.bsn();
        if (bsn == null) {
            return false;
        }
        try {
            bsn.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase bsn = g.bsn();
        if (bsn == null) {
            return null;
        }
        try {
            return bsn.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bsn = g.bsn();
        if (bsn == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bsn.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bsn = g.bsn();
        if (bsn == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bsn.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase bsn = g.bsn();
        if (bsn == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bsn.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase bsn;
        if (TextUtils.isEmpty(str) || (bsn = g.bsn()) == null) {
            return null;
        }
        try {
            return bsn.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
