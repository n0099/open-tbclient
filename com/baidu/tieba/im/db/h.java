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
    private static h gFk;

    public static h bAs() {
        if (gFk == null) {
            synchronized (h.class) {
                if (gFk == null) {
                    gFk = new h();
                }
            }
        }
        return gFk;
    }

    public void bAt() {
        SQLiteDatabase bAq = g.bAq();
        if (bAq != null) {
            if (bAq.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bAq.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bAu() {
        SQLiteDatabase bAq = g.bAq();
        if (bAq != null) {
            BdLog.i("begin commit transaction");
            if (bAq.inTransaction()) {
                try {
                    bAq.setTransactionSuccessful();
                    bAq.endTransaction();
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
        SQLiteDatabase bAq = g.bAq();
        if (bAq == null) {
            return false;
        }
        try {
            bAq.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase bAq = g.bAq();
        if (bAq == null) {
            return null;
        }
        try {
            return bAq.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bAq = g.bAq();
        if (bAq == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bAq.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bAq = g.bAq();
        if (bAq == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bAq.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase bAq = g.bAq();
        if (bAq == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bAq.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement xP(String str) {
        SQLiteDatabase bAq;
        if (TextUtils.isEmpty(str) || (bAq = g.bAq()) == null) {
            return null;
        }
        try {
            return bAq.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
