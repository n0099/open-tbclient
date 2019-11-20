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
    private static h gEt;

    public static h bAq() {
        if (gEt == null) {
            synchronized (h.class) {
                if (gEt == null) {
                    gEt = new h();
                }
            }
        }
        return gEt;
    }

    public void bAr() {
        SQLiteDatabase bAo = g.bAo();
        if (bAo != null) {
            if (bAo.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bAo.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bAs() {
        SQLiteDatabase bAo = g.bAo();
        if (bAo != null) {
            BdLog.i("begin commit transaction");
            if (bAo.inTransaction()) {
                try {
                    bAo.setTransactionSuccessful();
                    bAo.endTransaction();
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

    public boolean xO(String str) {
        SQLiteDatabase bAo = g.bAo();
        if (bAo == null) {
            return false;
        }
        try {
            bAo.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase bAo = g.bAo();
        if (bAo == null) {
            return null;
        }
        try {
            return bAo.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bAo = g.bAo();
        if (bAo == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bAo.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bAo = g.bAo();
        if (bAo == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bAo.update(str, contentValues, str2, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1;
        }
    }

    public long a(SQLiteStatement sQLiteStatement) {
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

    public long a(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase bAo = g.bAo();
        if (bAo == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bAo.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement xP(String str) {
        SQLiteDatabase bAo;
        if (TextUtils.isEmpty(str) || (bAo = g.bAo()) == null) {
            return null;
        }
        try {
            return bAo.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
