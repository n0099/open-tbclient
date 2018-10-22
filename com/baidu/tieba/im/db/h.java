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
    private static h eFy;

    public static h aPh() {
        if (eFy == null) {
            synchronized (h.class) {
                if (eFy == null) {
                    eFy = new h();
                }
            }
        }
        return eFy;
    }

    public void aPi() {
        SQLiteDatabase aPf = g.aPf();
        if (aPf != null) {
            if (aPf.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aPf.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aPf = g.aPf();
        if (aPf != null) {
            BdLog.i("begin commit transaction");
            if (aPf.inTransaction()) {
                try {
                    aPf.setTransactionSuccessful();
                    aPf.endTransaction();
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

    public boolean pw(String str) {
        SQLiteDatabase aPf = g.aPf();
        if (aPf == null) {
            return false;
        }
        try {
            aPf.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aPf = g.aPf();
        if (aPf == null) {
            return null;
        }
        try {
            return aPf.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aPf = g.aPf();
        if (aPf == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aPf.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aPf = g.aPf();
        if (aPf == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aPf.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aPf = g.aPf();
        if (aPf == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aPf.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aPf;
        if (TextUtils.isEmpty(str) || (aPf = g.aPf()) == null) {
            return null;
        }
        try {
            return aPf.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
