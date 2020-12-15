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
    private static h kqC;

    public static h cVW() {
        if (kqC == null) {
            synchronized (h.class) {
                if (kqC == null) {
                    kqC = new h();
                }
            }
        }
        return kqC;
    }

    public void cVX() {
        SQLiteDatabase cVU = g.cVU();
        if (cVU != null) {
            if (cVU.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cVU.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cVY() {
        SQLiteDatabase cVU = g.cVU();
        if (cVU != null) {
            BdLog.i("begin commit transaction");
            if (cVU.inTransaction()) {
                try {
                    cVU.setTransactionSuccessful();
                    cVU.endTransaction();
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
        SQLiteDatabase cVU = g.cVU();
        if (cVU == null) {
            return false;
        }
        try {
            cVU.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cVU = g.cVU();
        if (cVU == null) {
            return null;
        }
        try {
            return cVU.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase cVU = g.cVU();
        if (cVU == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cVU.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cVU = g.cVU();
        if (cVU == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cVU.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cVU = g.cVU();
        if (cVU == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cVU.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement Nr(String str) {
        SQLiteDatabase cVU;
        if (TextUtils.isEmpty(str) || (cVU = g.cVU()) == null) {
            return null;
        }
        try {
            return cVU.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
