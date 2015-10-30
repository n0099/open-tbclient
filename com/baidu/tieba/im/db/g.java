package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class g {
    private static g bwS;

    public static g TF() {
        if (bwS == null) {
            synchronized (g.class) {
                if (bwS == null) {
                    bwS = new g();
                }
            }
        }
        return bwS;
    }

    public void TG() {
        SQLiteDatabase TD = f.TD();
        if (TD != null) {
            if (TD.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                TD.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase TD = f.TD();
        if (TD != null) {
            BdLog.i("begin commit transaction");
            if (TD.inTransaction()) {
                try {
                    TD.setTransactionSuccessful();
                    TD.endTransaction();
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

    public boolean hP(String str) {
        SQLiteDatabase TD = f.TD();
        if (TD == null) {
            return false;
        }
        try {
            TD.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase TD = f.TD();
        if (TD == null) {
            return null;
        }
        try {
            return TD.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase TD = f.TD();
        if (TD == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return TD.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase TD = f.TD();
        if (TD == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return TD.update(str, contentValues, str2, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1;
        }
    }

    public long b(SQLiteStatement sQLiteStatement) {
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

    public long insert(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase TD = f.TD();
        if (TD == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return TD.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase TD;
        if (TextUtils.isEmpty(str) || (TD = f.TD()) == null) {
            return null;
        }
        try {
            return TD.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
