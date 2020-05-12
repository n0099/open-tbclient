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
    private static h ijG;

    public static h cfl() {
        if (ijG == null) {
            synchronized (h.class) {
                if (ijG == null) {
                    ijG = new h();
                }
            }
        }
        return ijG;
    }

    public void cfm() {
        SQLiteDatabase cfj = g.cfj();
        if (cfj != null) {
            if (cfj.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cfj.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cfn() {
        SQLiteDatabase cfj = g.cfj();
        if (cfj != null) {
            BdLog.i("begin commit transaction");
            if (cfj.inTransaction()) {
                try {
                    cfj.setTransactionSuccessful();
                    cfj.endTransaction();
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

    public boolean EJ(String str) {
        SQLiteDatabase cfj = g.cfj();
        if (cfj == null) {
            return false;
        }
        try {
            cfj.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cfj = g.cfj();
        if (cfj == null) {
            return null;
        }
        try {
            return cfj.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase cfj = g.cfj();
        if (cfj == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cfj.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cfj = g.cfj();
        if (cfj == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cfj.update(str, contentValues, str2, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1;
        }
    }

    public long a(SQLiteStatement sQLiteStatement) {
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

    public long a(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase cfj = g.cfj();
        if (cfj == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cfj.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement EK(String str) {
        SQLiteDatabase cfj;
        if (TextUtils.isEmpty(str) || (cfj = g.cfj()) == null) {
            return null;
        }
        try {
            return cfj.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
