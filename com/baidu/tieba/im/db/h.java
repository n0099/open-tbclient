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
    private static h hym;

    public static h bUt() {
        if (hym == null) {
            synchronized (h.class) {
                if (hym == null) {
                    hym = new h();
                }
            }
        }
        return hym;
    }

    public void bUu() {
        SQLiteDatabase bUr = g.bUr();
        if (bUr != null) {
            if (bUr.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bUr.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bUv() {
        SQLiteDatabase bUr = g.bUr();
        if (bUr != null) {
            BdLog.i("begin commit transaction");
            if (bUr.inTransaction()) {
                try {
                    bUr.setTransactionSuccessful();
                    bUr.endTransaction();
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

    public boolean CY(String str) {
        SQLiteDatabase bUr = g.bUr();
        if (bUr == null) {
            return false;
        }
        try {
            bUr.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase bUr = g.bUr();
        if (bUr == null) {
            return null;
        }
        try {
            return bUr.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bUr = g.bUr();
        if (bUr == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bUr.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bUr = g.bUr();
        if (bUr == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bUr.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase bUr = g.bUr();
        if (bUr == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bUr.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement CZ(String str) {
        SQLiteDatabase bUr;
        if (TextUtils.isEmpty(str) || (bUr = g.bUr()) == null) {
            return null;
        }
        try {
            return bUr.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
