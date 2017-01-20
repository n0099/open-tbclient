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
    private static g cSp;

    public static g aql() {
        if (cSp == null) {
            synchronized (g.class) {
                if (cSp == null) {
                    cSp = new g();
                }
            }
        }
        return cSp;
    }

    public void aqm() {
        SQLiteDatabase aqj = f.aqj();
        if (aqj != null) {
            if (aqj.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aqj.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aqj = f.aqj();
        if (aqj != null) {
            BdLog.i("begin commit transaction");
            if (aqj.inTransaction()) {
                try {
                    aqj.setTransactionSuccessful();
                    aqj.endTransaction();
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

    public boolean kL(String str) {
        SQLiteDatabase aqj = f.aqj();
        if (aqj == null) {
            return false;
        }
        try {
            aqj.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aqj = f.aqj();
        if (aqj == null) {
            return null;
        }
        try {
            return aqj.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aqj = f.aqj();
        if (aqj == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aqj.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aqj = f.aqj();
        if (aqj == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aqj.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aqj = f.aqj();
        if (aqj == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aqj.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aqj;
        if (TextUtils.isEmpty(str) || (aqj = f.aqj()) == null) {
            return null;
        }
        try {
            return aqj.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
