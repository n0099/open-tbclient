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
    private static h kqA;

    public static h cVV() {
        if (kqA == null) {
            synchronized (h.class) {
                if (kqA == null) {
                    kqA = new h();
                }
            }
        }
        return kqA;
    }

    public void cVW() {
        SQLiteDatabase cVT = g.cVT();
        if (cVT != null) {
            if (cVT.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cVT.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cVX() {
        SQLiteDatabase cVT = g.cVT();
        if (cVT != null) {
            BdLog.i("begin commit transaction");
            if (cVT.inTransaction()) {
                try {
                    cVT.setTransactionSuccessful();
                    cVT.endTransaction();
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

    public boolean Nq(String str) {
        SQLiteDatabase cVT = g.cVT();
        if (cVT == null) {
            return false;
        }
        try {
            cVT.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cVT = g.cVT();
        if (cVT == null) {
            return null;
        }
        try {
            return cVT.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase cVT = g.cVT();
        if (cVT == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cVT.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cVT = g.cVT();
        if (cVT == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cVT.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cVT = g.cVT();
        if (cVT == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cVT.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement Nr(String str) {
        SQLiteDatabase cVT;
        if (TextUtils.isEmpty(str) || (cVT = g.cVT()) == null) {
            return null;
        }
        try {
            return cVT.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
