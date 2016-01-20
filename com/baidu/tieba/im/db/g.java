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
    private static g bQb;

    public static g Ym() {
        if (bQb == null) {
            synchronized (g.class) {
                if (bQb == null) {
                    bQb = new g();
                }
            }
        }
        return bQb;
    }

    public void Yn() {
        SQLiteDatabase Yk = f.Yk();
        if (Yk != null) {
            if (Yk.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                Yk.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase Yk = f.Yk();
        if (Yk != null) {
            BdLog.i("begin commit transaction");
            if (Yk.inTransaction()) {
                try {
                    Yk.setTransactionSuccessful();
                    Yk.endTransaction();
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

    public boolean iz(String str) {
        SQLiteDatabase Yk = f.Yk();
        if (Yk == null) {
            return false;
        }
        try {
            Yk.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase Yk = f.Yk();
        if (Yk == null) {
            return null;
        }
        try {
            return Yk.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase Yk = f.Yk();
        if (Yk == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Yk.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase Yk = f.Yk();
        if (Yk == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Yk.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase Yk = f.Yk();
        if (Yk == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Yk.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase Yk;
        if (TextUtils.isEmpty(str) || (Yk = f.Yk()) == null) {
            return null;
        }
        try {
            return Yk.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
