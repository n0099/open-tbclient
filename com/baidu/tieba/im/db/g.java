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
    private static g aYf;

    public static g MP() {
        if (aYf == null) {
            synchronized (g.class) {
                if (aYf == null) {
                    aYf = new g();
                }
            }
        }
        return aYf;
    }

    public void MQ() {
        SQLiteDatabase MN = f.MN();
        if (MN != null) {
            if (MN.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                MN.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase MN = f.MN();
        if (MN != null) {
            BdLog.i("begin commit transaction");
            if (MN.inTransaction()) {
                try {
                    MN.setTransactionSuccessful();
                    MN.endTransaction();
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

    public boolean gu(String str) {
        SQLiteDatabase MN = f.MN();
        if (MN == null) {
            return false;
        }
        try {
            MN.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase MN = f.MN();
        if (MN == null) {
            return null;
        }
        try {
            return MN.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase MN = f.MN();
        if (MN == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return MN.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase MN = f.MN();
        if (MN == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return MN.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase MN = f.MN();
        if (MN == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return MN.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase MN;
        if (TextUtils.isEmpty(str) || (MN = f.MN()) == null) {
            return null;
        }
        try {
            return MN.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
