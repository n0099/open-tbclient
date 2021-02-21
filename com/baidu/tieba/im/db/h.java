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
    private static h kFg;

    public static h cVG() {
        if (kFg == null) {
            synchronized (h.class) {
                if (kFg == null) {
                    kFg = new h();
                }
            }
        }
        return kFg;
    }

    public void cVH() {
        SQLiteDatabase cVE = g.cVE();
        if (cVE != null) {
            if (cVE.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cVE.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cVI() {
        SQLiteDatabase cVE = g.cVE();
        if (cVE != null) {
            BdLog.i("begin commit transaction");
            if (cVE.inTransaction()) {
                try {
                    cVE.setTransactionSuccessful();
                    cVE.endTransaction();
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

    public boolean MR(String str) {
        SQLiteDatabase cVE = g.cVE();
        if (cVE == null) {
            return false;
        }
        try {
            cVE.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cVE = g.cVE();
        if (cVE == null) {
            return null;
        }
        try {
            return cVE.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean b(String str, String str2, String[] strArr) {
        SQLiteDatabase cVE = g.cVE();
        if (cVE == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cVE.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int b(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cVE = g.cVE();
        if (cVE == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cVE.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cVE = g.cVE();
        if (cVE == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cVE.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement MS(String str) {
        SQLiteDatabase cVE;
        if (TextUtils.isEmpty(str) || (cVE = g.cVE()) == null) {
            return null;
        }
        try {
            return cVE.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
