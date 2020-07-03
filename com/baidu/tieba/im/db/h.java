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
    private static h iQg;

    public static h cpG() {
        if (iQg == null) {
            synchronized (h.class) {
                if (iQg == null) {
                    iQg = new h();
                }
            }
        }
        return iQg;
    }

    public void cpH() {
        SQLiteDatabase cpE = g.cpE();
        if (cpE != null) {
            if (cpE.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cpE.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cpI() {
        SQLiteDatabase cpE = g.cpE();
        if (cpE != null) {
            BdLog.i("begin commit transaction");
            if (cpE.inTransaction()) {
                try {
                    cpE.setTransactionSuccessful();
                    cpE.endTransaction();
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

    public boolean GU(String str) {
        SQLiteDatabase cpE = g.cpE();
        if (cpE == null) {
            return false;
        }
        try {
            cpE.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cpE = g.cpE();
        if (cpE == null) {
            return null;
        }
        try {
            return cpE.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase cpE = g.cpE();
        if (cpE == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cpE.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cpE = g.cpE();
        if (cpE == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cpE.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cpE = g.cpE();
        if (cpE == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cpE.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement GV(String str) {
        SQLiteDatabase cpE;
        if (TextUtils.isEmpty(str) || (cpE = g.cpE()) == null) {
            return null;
        }
        try {
            return cpE.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
