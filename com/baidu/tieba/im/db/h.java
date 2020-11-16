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
    private static h kcW;

    public static h cQH() {
        if (kcW == null) {
            synchronized (h.class) {
                if (kcW == null) {
                    kcW = new h();
                }
            }
        }
        return kcW;
    }

    public void cQI() {
        SQLiteDatabase cQF = g.cQF();
        if (cQF != null) {
            if (cQF.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cQF.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cQJ() {
        SQLiteDatabase cQF = g.cQF();
        if (cQF != null) {
            BdLog.i("begin commit transaction");
            if (cQF.inTransaction()) {
                try {
                    cQF.setTransactionSuccessful();
                    cQF.endTransaction();
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

    public boolean Mi(String str) {
        SQLiteDatabase cQF = g.cQF();
        if (cQF == null) {
            return false;
        }
        try {
            cQF.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cQF = g.cQF();
        if (cQF == null) {
            return null;
        }
        try {
            return cQF.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase cQF = g.cQF();
        if (cQF == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cQF.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cQF = g.cQF();
        if (cQF == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cQF.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cQF = g.cQF();
        if (cQF == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cQF.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement Mj(String str) {
        SQLiteDatabase cQF;
        if (TextUtils.isEmpty(str) || (cQF = g.cQF()) == null) {
            return null;
        }
        try {
            return cQF.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
