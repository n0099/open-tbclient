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
    private static g bfh;

    public static g Rq() {
        if (bfh == null) {
            synchronized (g.class) {
                if (bfh == null) {
                    bfh = new g();
                }
            }
        }
        return bfh;
    }

    public void Rr() {
        SQLiteDatabase Ro = f.Ro();
        if (Ro != null) {
            if (Ro.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                Ro.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase Ro = f.Ro();
        if (Ro != null) {
            BdLog.i("begin commit transaction");
            if (Ro.inTransaction()) {
                try {
                    Ro.setTransactionSuccessful();
                    Ro.endTransaction();
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

    public boolean hd(String str) {
        SQLiteDatabase Ro = f.Ro();
        if (Ro == null) {
            return false;
        }
        try {
            Ro.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase Ro = f.Ro();
        if (Ro == null) {
            return null;
        }
        try {
            return Ro.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase Ro = f.Ro();
        if (Ro == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Ro.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase Ro = f.Ro();
        if (Ro == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Ro.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase Ro = f.Ro();
        if (Ro == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Ro.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase Ro;
        if (TextUtils.isEmpty(str) || (Ro = f.Ro()) == null) {
            return null;
        }
        try {
            return Ro.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
