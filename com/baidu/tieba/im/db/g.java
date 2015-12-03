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
    private static g bMv;

    public static g Xg() {
        if (bMv == null) {
            synchronized (g.class) {
                if (bMv == null) {
                    bMv = new g();
                }
            }
        }
        return bMv;
    }

    public void Xh() {
        SQLiteDatabase Xe = f.Xe();
        if (Xe != null) {
            if (Xe.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                Xe.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase Xe = f.Xe();
        if (Xe != null) {
            BdLog.i("begin commit transaction");
            if (Xe.inTransaction()) {
                try {
                    Xe.setTransactionSuccessful();
                    Xe.endTransaction();
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

    public boolean im(String str) {
        SQLiteDatabase Xe = f.Xe();
        if (Xe == null) {
            return false;
        }
        try {
            Xe.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase Xe = f.Xe();
        if (Xe == null) {
            return null;
        }
        try {
            return Xe.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase Xe = f.Xe();
        if (Xe == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Xe.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase Xe = f.Xe();
        if (Xe == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Xe.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase Xe = f.Xe();
        if (Xe == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Xe.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase Xe;
        if (TextUtils.isEmpty(str) || (Xe = f.Xe()) == null) {
            return null;
        }
        try {
            return Xe.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
