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
    private static g daA;

    public static g asI() {
        if (daA == null) {
            synchronized (g.class) {
                if (daA == null) {
                    daA = new g();
                }
            }
        }
        return daA;
    }

    public void asJ() {
        SQLiteDatabase asG = f.asG();
        if (asG != null) {
            if (asG.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                asG.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase asG = f.asG();
        if (asG != null) {
            BdLog.i("begin commit transaction");
            if (asG.inTransaction()) {
                try {
                    asG.setTransactionSuccessful();
                    asG.endTransaction();
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

    public boolean lH(String str) {
        SQLiteDatabase asG = f.asG();
        if (asG == null) {
            return false;
        }
        try {
            asG.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase asG = f.asG();
        if (asG == null) {
            return null;
        }
        try {
            return asG.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase asG = f.asG();
        if (asG == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return asG.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase asG = f.asG();
        if (asG == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return asG.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase asG = f.asG();
        if (asG == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return asG.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase asG;
        if (TextUtils.isEmpty(str) || (asG = f.asG()) == null) {
            return null;
        }
        try {
            return asG.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
