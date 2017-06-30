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
    private static g dcQ;

    public static g asd() {
        if (dcQ == null) {
            synchronized (g.class) {
                if (dcQ == null) {
                    dcQ = new g();
                }
            }
        }
        return dcQ;
    }

    public void ase() {
        SQLiteDatabase asb = f.asb();
        if (asb != null) {
            if (asb.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                asb.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase asb = f.asb();
        if (asb != null) {
            BdLog.i("begin commit transaction");
            if (asb.inTransaction()) {
                try {
                    asb.setTransactionSuccessful();
                    asb.endTransaction();
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

    public boolean lF(String str) {
        SQLiteDatabase asb = f.asb();
        if (asb == null) {
            return false;
        }
        try {
            asb.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase asb = f.asb();
        if (asb == null) {
            return null;
        }
        try {
            return asb.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase asb = f.asb();
        if (asb == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return asb.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase asb = f.asb();
        if (asb == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return asb.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase asb = f.asb();
        if (asb == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return asb.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase asb;
        if (TextUtils.isEmpty(str) || (asb = f.asb()) == null) {
            return null;
        }
        try {
            return asb.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
