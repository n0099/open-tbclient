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
    private static h eBP;

    public static h aIg() {
        if (eBP == null) {
            synchronized (h.class) {
                if (eBP == null) {
                    eBP = new h();
                }
            }
        }
        return eBP;
    }

    public void aIh() {
        SQLiteDatabase aIe = g.aIe();
        if (aIe != null) {
            if (aIe.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aIe.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aIe = g.aIe();
        if (aIe != null) {
            BdLog.i("begin commit transaction");
            if (aIe.inTransaction()) {
                try {
                    aIe.setTransactionSuccessful();
                    aIe.endTransaction();
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

    public boolean np(String str) {
        SQLiteDatabase aIe = g.aIe();
        if (aIe == null) {
            return false;
        }
        try {
            aIe.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aIe = g.aIe();
        if (aIe == null) {
            return null;
        }
        try {
            return aIe.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aIe = g.aIe();
        if (aIe == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aIe.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aIe = g.aIe();
        if (aIe == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aIe.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aIe = g.aIe();
        if (aIe == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aIe.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aIe;
        if (TextUtils.isEmpty(str) || (aIe = g.aIe()) == null) {
            return null;
        }
        try {
            return aIe.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
