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

    public static h aQv() {
        if (eNG == null) {
            synchronized (h.class) {
                if (eNG == null) {
                    eNG = new h();
                }
            }
        }
        return eNG;
    }

    public void aQw() {
        SQLiteDatabase aQt = g.aQt();
        if (aQt != null) {
            if (aQt.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aQt.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aQt = g.aQt();
        if (aQt != null) {
            BdLog.i("begin commit transaction");
            if (aQt.inTransaction()) {
                try {
                    aQt.setTransactionSuccessful();
                    aQt.endTransaction();
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
        SQLiteDatabase aQt = g.aQt();
        if (aQt == null) {
            return false;
        }
        try {
            aQt.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aQt = g.aQt();
        if (aQt == null) {
            return null;
        }
        try {
            return aQt.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aQt = g.aQt();
        if (aQt == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aQt.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aQt = g.aQt();
        if (aQt == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aQt.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aQt = g.aQt();
        if (aQt == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aQt.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aQt;
        if (TextUtils.isEmpty(str) || (aQt = g.aQt()) == null) {
            return null;
        }
        try {
            return aQt.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
