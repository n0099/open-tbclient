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
    private static h eqs;

    public static h aJD() {
        if (eqs == null) {
            synchronized (h.class) {
                if (eqs == null) {
                    eqs = new h();
                }
            }
        }
        return eqs;
    }

    public void aJE() {
        SQLiteDatabase aJB = g.aJB();
        if (aJB != null) {
            if (aJB.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aJB.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aJB = g.aJB();
        if (aJB != null) {
            BdLog.i("begin commit transaction");
            if (aJB.inTransaction()) {
                try {
                    aJB.setTransactionSuccessful();
                    aJB.endTransaction();
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

    public boolean op(String str) {
        SQLiteDatabase aJB = g.aJB();
        if (aJB == null) {
            return false;
        }
        try {
            aJB.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aJB = g.aJB();
        if (aJB == null) {
            return null;
        }
        try {
            return aJB.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aJB = g.aJB();
        if (aJB == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aJB.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aJB = g.aJB();
        if (aJB == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aJB.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aJB = g.aJB();
        if (aJB == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aJB.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aJB;
        if (TextUtils.isEmpty(str) || (aJB = g.aJB()) == null) {
            return null;
        }
        try {
            return aJB.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
