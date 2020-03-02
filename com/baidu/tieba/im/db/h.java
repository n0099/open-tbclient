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
    private static h hya;

    public static h bUs() {
        if (hya == null) {
            synchronized (h.class) {
                if (hya == null) {
                    hya = new h();
                }
            }
        }
        return hya;
    }

    public void bUt() {
        SQLiteDatabase bUq = g.bUq();
        if (bUq != null) {
            if (bUq.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bUq.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bUu() {
        SQLiteDatabase bUq = g.bUq();
        if (bUq != null) {
            BdLog.i("begin commit transaction");
            if (bUq.inTransaction()) {
                try {
                    bUq.setTransactionSuccessful();
                    bUq.endTransaction();
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

    public boolean CX(String str) {
        SQLiteDatabase bUq = g.bUq();
        if (bUq == null) {
            return false;
        }
        try {
            bUq.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase bUq = g.bUq();
        if (bUq == null) {
            return null;
        }
        try {
            return bUq.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bUq = g.bUq();
        if (bUq == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bUq.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bUq = g.bUq();
        if (bUq == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bUq.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase bUq = g.bUq();
        if (bUq == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bUq.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement CY(String str) {
        SQLiteDatabase bUq;
        if (TextUtils.isEmpty(str) || (bUq = g.bUq()) == null) {
            return null;
        }
        try {
            return bUq.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
