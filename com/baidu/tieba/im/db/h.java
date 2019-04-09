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
    private static h ghc;

    public static h bsl() {
        if (ghc == null) {
            synchronized (h.class) {
                if (ghc == null) {
                    ghc = new h();
                }
            }
        }
        return ghc;
    }

    public void bsm() {
        SQLiteDatabase bsj = g.bsj();
        if (bsj != null) {
            if (bsj.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bsj.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase bsj = g.bsj();
        if (bsj != null) {
            BdLog.i("begin commit transaction");
            if (bsj.inTransaction()) {
                try {
                    bsj.setTransactionSuccessful();
                    bsj.endTransaction();
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

    public boolean wV(String str) {
        SQLiteDatabase bsj = g.bsj();
        if (bsj == null) {
            return false;
        }
        try {
            bsj.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase bsj = g.bsj();
        if (bsj == null) {
            return null;
        }
        try {
            return bsj.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bsj = g.bsj();
        if (bsj == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bsj.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bsj = g.bsj();
        if (bsj == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bsj.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase bsj = g.bsj();
        if (bsj == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bsj.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase bsj;
        if (TextUtils.isEmpty(str) || (bsj = g.bsj()) == null) {
            return null;
        }
        try {
            return bsj.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
