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
    private static g dgm;

    public static g auF() {
        if (dgm == null) {
            synchronized (g.class) {
                if (dgm == null) {
                    dgm = new g();
                }
            }
        }
        return dgm;
    }

    public void auG() {
        SQLiteDatabase auD = f.auD();
        if (auD != null) {
            if (auD.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                auD.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase auD = f.auD();
        if (auD != null) {
            BdLog.i("begin commit transaction");
            if (auD.inTransaction()) {
                try {
                    auD.setTransactionSuccessful();
                    auD.endTransaction();
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

    public boolean lU(String str) {
        SQLiteDatabase auD = f.auD();
        if (auD == null) {
            return false;
        }
        try {
            auD.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase auD = f.auD();
        if (auD == null) {
            return null;
        }
        try {
            return auD.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase auD = f.auD();
        if (auD == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return auD.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase auD = f.auD();
        if (auD == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return auD.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase auD = f.auD();
        if (auD == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return auD.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase auD;
        if (TextUtils.isEmpty(str) || (auD = f.auD()) == null) {
            return null;
        }
        try {
            return auD.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
