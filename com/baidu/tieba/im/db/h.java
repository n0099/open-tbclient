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
    private static h izb;

    public static h clR() {
        if (izb == null) {
            synchronized (h.class) {
                if (izb == null) {
                    izb = new h();
                }
            }
        }
        return izb;
    }

    public void clS() {
        SQLiteDatabase clP = g.clP();
        if (clP != null) {
            if (clP.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                clP.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void clT() {
        SQLiteDatabase clP = g.clP();
        if (clP != null) {
            BdLog.i("begin commit transaction");
            if (clP.inTransaction()) {
                try {
                    clP.setTransactionSuccessful();
                    clP.endTransaction();
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

    public boolean Gs(String str) {
        SQLiteDatabase clP = g.clP();
        if (clP == null) {
            return false;
        }
        try {
            clP.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase clP = g.clP();
        if (clP == null) {
            return null;
        }
        try {
            return clP.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase clP = g.clP();
        if (clP == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return clP.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase clP = g.clP();
        if (clP == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return clP.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase clP = g.clP();
        if (clP == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return clP.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement Gt(String str) {
        SQLiteDatabase clP;
        if (TextUtils.isEmpty(str) || (clP = g.clP()) == null) {
            return null;
        }
        try {
            return clP.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
