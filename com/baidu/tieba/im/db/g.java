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
    private static g dAa;

    public static g axv() {
        if (dAa == null) {
            synchronized (g.class) {
                if (dAa == null) {
                    dAa = new g();
                }
            }
        }
        return dAa;
    }

    public void axw() {
        SQLiteDatabase axt = f.axt();
        if (axt != null) {
            if (axt.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                axt.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase axt = f.axt();
        if (axt != null) {
            BdLog.i("begin commit transaction");
            if (axt.inTransaction()) {
                try {
                    axt.setTransactionSuccessful();
                    axt.endTransaction();
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

    public boolean mA(String str) {
        SQLiteDatabase axt = f.axt();
        if (axt == null) {
            return false;
        }
        try {
            axt.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase axt = f.axt();
        if (axt == null) {
            return null;
        }
        try {
            return axt.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase axt = f.axt();
        if (axt == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return axt.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase axt = f.axt();
        if (axt == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return axt.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase axt = f.axt();
        if (axt == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return axt.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase axt;
        if (TextUtils.isEmpty(str) || (axt = f.axt()) == null) {
            return null;
        }
        try {
            return axt.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
