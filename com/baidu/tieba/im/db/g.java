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
    private static g cfm;

    public static g aev() {
        if (cfm == null) {
            synchronized (g.class) {
                if (cfm == null) {
                    cfm = new g();
                }
            }
        }
        return cfm;
    }

    public void aew() {
        SQLiteDatabase aet = f.aet();
        if (aet != null) {
            if (aet.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aet.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aet = f.aet();
        if (aet != null) {
            BdLog.i("begin commit transaction");
            if (aet.inTransaction()) {
                try {
                    aet.setTransactionSuccessful();
                    aet.endTransaction();
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

    public boolean jl(String str) {
        SQLiteDatabase aet = f.aet();
        if (aet == null) {
            return false;
        }
        try {
            aet.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aet = f.aet();
        if (aet == null) {
            return null;
        }
        try {
            return aet.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aet = f.aet();
        if (aet == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aet.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aet = f.aet();
        if (aet == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aet.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aet = f.aet();
        if (aet == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aet.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aet;
        if (TextUtils.isEmpty(str) || (aet = f.aet()) == null) {
            return null;
        }
        try {
            return aet.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
