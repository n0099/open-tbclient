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
    private static h kwM;

    public static h cTB() {
        if (kwM == null) {
            synchronized (h.class) {
                if (kwM == null) {
                    kwM = new h();
                }
            }
        }
        return kwM;
    }

    public void cTC() {
        SQLiteDatabase cTz = g.cTz();
        if (cTz != null) {
            if (cTz.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cTz.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cTD() {
        SQLiteDatabase cTz = g.cTz();
        if (cTz != null) {
            BdLog.i("begin commit transaction");
            if (cTz.inTransaction()) {
                try {
                    cTz.setTransactionSuccessful();
                    cTz.endTransaction();
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

    public boolean Mb(String str) {
        SQLiteDatabase cTz = g.cTz();
        if (cTz == null) {
            return false;
        }
        try {
            cTz.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cTz = g.cTz();
        if (cTz == null) {
            return null;
        }
        try {
            return cTz.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean b(String str, String str2, String[] strArr) {
        SQLiteDatabase cTz = g.cTz();
        if (cTz == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cTz.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int b(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cTz = g.cTz();
        if (cTz == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cTz.update(str, contentValues, str2, strArr);
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

    public long b(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase cTz = g.cTz();
        if (cTz == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cTz.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement Mc(String str) {
        SQLiteDatabase cTz;
        if (TextUtils.isEmpty(str) || (cTz = g.cTz()) == null) {
            return null;
        }
        try {
            return cTz.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
