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
    private static g cLh;

    public static g ape() {
        if (cLh == null) {
            synchronized (g.class) {
                if (cLh == null) {
                    cLh = new g();
                }
            }
        }
        return cLh;
    }

    public void apf() {
        SQLiteDatabase apc = f.apc();
        if (apc != null) {
            if (apc.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                apc.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase apc = f.apc();
        if (apc != null) {
            BdLog.i("begin commit transaction");
            if (apc.inTransaction()) {
                try {
                    apc.setTransactionSuccessful();
                    apc.endTransaction();
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

    public boolean kx(String str) {
        SQLiteDatabase apc = f.apc();
        if (apc == null) {
            return false;
        }
        try {
            apc.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase apc = f.apc();
        if (apc == null) {
            return null;
        }
        try {
            return apc.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase apc = f.apc();
        if (apc == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return apc.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase apc = f.apc();
        if (apc == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return apc.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase apc = f.apc();
        if (apc == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return apc.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase apc;
        if (TextUtils.isEmpty(str) || (apc = f.apc()) == null) {
            return null;
        }
        try {
            return apc.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
