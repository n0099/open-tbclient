package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class g {
    private static g evv;

    public static g aGw() {
        if (evv == null) {
            synchronized (g.class) {
                if (evv == null) {
                    evv = new g();
                }
            }
        }
        return evv;
    }

    public void aGx() {
        SQLiteDatabase aGu = f.aGu();
        if (aGu != null) {
            if (aGu.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aGu.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aGu = f.aGu();
        if (aGu != null) {
            BdLog.i("begin commit transaction");
            if (aGu.inTransaction()) {
                try {
                    aGu.setTransactionSuccessful();
                    aGu.endTransaction();
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

    public boolean mU(String str) {
        SQLiteDatabase aGu = f.aGu();
        if (aGu == null) {
            return false;
        }
        try {
            aGu.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aGu = f.aGu();
        if (aGu == null) {
            return null;
        }
        try {
            return aGu.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aGu = f.aGu();
        if (aGu == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aGu.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aGu = f.aGu();
        if (aGu == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aGu.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aGu = f.aGu();
        if (aGu == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aGu.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aGu;
        if (TextUtils.isEmpty(str) || (aGu = f.aGu()) == null) {
            return null;
        }
        try {
            return aGu.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
