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
    private static g btE;

    public static g Tb() {
        if (btE == null) {
            synchronized (g.class) {
                if (btE == null) {
                    btE = new g();
                }
            }
        }
        return btE;
    }

    public void Tc() {
        SQLiteDatabase SZ = f.SZ();
        if (SZ != null) {
            if (SZ.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                SZ.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase SZ = f.SZ();
        if (SZ != null) {
            BdLog.i("begin commit transaction");
            if (SZ.inTransaction()) {
                try {
                    SZ.setTransactionSuccessful();
                    SZ.endTransaction();
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

    public boolean hL(String str) {
        SQLiteDatabase SZ = f.SZ();
        if (SZ == null) {
            return false;
        }
        try {
            SZ.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase SZ = f.SZ();
        if (SZ == null) {
            return null;
        }
        try {
            return SZ.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase SZ = f.SZ();
        if (SZ == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return SZ.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase SZ = f.SZ();
        if (SZ == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return SZ.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase SZ = f.SZ();
        if (SZ == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return SZ.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase SZ;
        if (TextUtils.isEmpty(str) || (SZ = f.SZ()) == null) {
            return null;
        }
        try {
            return SZ.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
