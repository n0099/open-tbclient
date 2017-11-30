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
    private static g dIi;

    public static g azm() {
        if (dIi == null) {
            synchronized (g.class) {
                if (dIi == null) {
                    dIi = new g();
                }
            }
        }
        return dIi;
    }

    public void azn() {
        SQLiteDatabase azk = f.azk();
        if (azk != null) {
            if (azk.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                azk.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase azk = f.azk();
        if (azk != null) {
            BdLog.i("begin commit transaction");
            if (azk.inTransaction()) {
                try {
                    azk.setTransactionSuccessful();
                    azk.endTransaction();
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

    public boolean mL(String str) {
        SQLiteDatabase azk = f.azk();
        if (azk == null) {
            return false;
        }
        try {
            azk.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase azk = f.azk();
        if (azk == null) {
            return null;
        }
        try {
            return azk.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase azk = f.azk();
        if (azk == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return azk.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase azk = f.azk();
        if (azk == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return azk.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase azk = f.azk();
        if (azk == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return azk.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase azk;
        if (TextUtils.isEmpty(str) || (azk = f.azk()) == null) {
            return null;
        }
        try {
            return azk.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
