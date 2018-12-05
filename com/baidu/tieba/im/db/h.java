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
    private static h eNG;

    public static h aQw() {
        if (eNG == null) {
            synchronized (h.class) {
                if (eNG == null) {
                    eNG = new h();
                }
            }
        }
        return eNG;
    }

    public void aQx() {
        SQLiteDatabase aQu = g.aQu();
        if (aQu != null) {
            if (aQu.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aQu.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aQu = g.aQu();
        if (aQu != null) {
            BdLog.i("begin commit transaction");
            if (aQu.inTransaction()) {
                try {
                    aQu.setTransactionSuccessful();
                    aQu.endTransaction();
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

    public boolean pZ(String str) {
        SQLiteDatabase aQu = g.aQu();
        if (aQu == null) {
            return false;
        }
        try {
            aQu.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aQu = g.aQu();
        if (aQu == null) {
            return null;
        }
        try {
            return aQu.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aQu = g.aQu();
        if (aQu == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aQu.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aQu = g.aQu();
        if (aQu == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aQu.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aQu = g.aQu();
        if (aQu == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aQu.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aQu;
        if (TextUtils.isEmpty(str) || (aQu = g.aQu()) == null) {
            return null;
        }
        try {
            return aQu.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
