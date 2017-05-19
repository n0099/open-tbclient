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
    private static g cPv;

    public static g ans() {
        if (cPv == null) {
            synchronized (g.class) {
                if (cPv == null) {
                    cPv = new g();
                }
            }
        }
        return cPv;
    }

    public void ant() {
        SQLiteDatabase anq = f.anq();
        if (anq != null) {
            if (anq.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                anq.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase anq = f.anq();
        if (anq != null) {
            BdLog.i("begin commit transaction");
            if (anq.inTransaction()) {
                try {
                    anq.setTransactionSuccessful();
                    anq.endTransaction();
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

    public boolean kx(String str) {
        SQLiteDatabase anq = f.anq();
        if (anq == null) {
            return false;
        }
        try {
            anq.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase anq = f.anq();
        if (anq == null) {
            return null;
        }
        try {
            return anq.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase anq = f.anq();
        if (anq == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return anq.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase anq = f.anq();
        if (anq == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return anq.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase anq = f.anq();
        if (anq == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return anq.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase anq;
        if (TextUtils.isEmpty(str) || (anq = f.anq()) == null) {
            return null;
        }
        try {
            return anq.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
