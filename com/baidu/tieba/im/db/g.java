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
    private static g aYg;

    public static g MU() {
        if (aYg == null) {
            synchronized (g.class) {
                if (aYg == null) {
                    aYg = new g();
                }
            }
        }
        return aYg;
    }

    public void MV() {
        SQLiteDatabase MS = f.MS();
        if (MS != null) {
            if (MS.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                MS.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase MS = f.MS();
        if (MS != null) {
            BdLog.i("begin commit transaction");
            if (MS.inTransaction()) {
                try {
                    MS.setTransactionSuccessful();
                    MS.endTransaction();
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

    public boolean gx(String str) {
        SQLiteDatabase MS = f.MS();
        if (MS == null) {
            return false;
        }
        try {
            MS.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase MS = f.MS();
        if (MS == null) {
            return null;
        }
        try {
            return MS.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase MS = f.MS();
        if (MS == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return MS.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase MS = f.MS();
        if (MS == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return MS.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase MS = f.MS();
        if (MS == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return MS.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase MS;
        if (TextUtils.isEmpty(str) || (MS = f.MS()) == null) {
            return null;
        }
        try {
            return MS.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
