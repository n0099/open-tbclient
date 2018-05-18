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
    private static h dXx;

    public static h aDd() {
        if (dXx == null) {
            synchronized (h.class) {
                if (dXx == null) {
                    dXx = new h();
                }
            }
        }
        return dXx;
    }

    public void aDe() {
        SQLiteDatabase aDb = g.aDb();
        if (aDb != null) {
            if (aDb.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aDb.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aDb = g.aDb();
        if (aDb != null) {
            BdLog.i("begin commit transaction");
            if (aDb.inTransaction()) {
                try {
                    aDb.setTransactionSuccessful();
                    aDb.endTransaction();
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

    public boolean nw(String str) {
        SQLiteDatabase aDb = g.aDb();
        if (aDb == null) {
            return false;
        }
        try {
            aDb.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aDb = g.aDb();
        if (aDb == null) {
            return null;
        }
        try {
            return aDb.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean b(String str, String str2, String[] strArr) {
        SQLiteDatabase aDb = g.aDb();
        if (aDb == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aDb.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aDb = g.aDb();
        if (aDb == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aDb.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aDb = g.aDb();
        if (aDb == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aDb.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aDb;
        if (TextUtils.isEmpty(str) || (aDb = g.aDb()) == null) {
            return null;
        }
        try {
            return aDb.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
