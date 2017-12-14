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
    private static g dJl;

    public static g azv() {
        if (dJl == null) {
            synchronized (g.class) {
                if (dJl == null) {
                    dJl = new g();
                }
            }
        }
        return dJl;
    }

    public void azw() {
        SQLiteDatabase azt = f.azt();
        if (azt != null) {
            if (azt.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                azt.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase azt = f.azt();
        if (azt != null) {
            BdLog.i("begin commit transaction");
            if (azt.inTransaction()) {
                try {
                    azt.setTransactionSuccessful();
                    azt.endTransaction();
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
        SQLiteDatabase azt = f.azt();
        if (azt == null) {
            return false;
        }
        try {
            azt.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase azt = f.azt();
        if (azt == null) {
            return null;
        }
        try {
            return azt.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase azt = f.azt();
        if (azt == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return azt.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase azt = f.azt();
        if (azt == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return azt.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase azt = f.azt();
        if (azt == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return azt.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase azt;
        if (TextUtils.isEmpty(str) || (azt = f.azt()) == null) {
            return null;
        }
        try {
            return azt.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
