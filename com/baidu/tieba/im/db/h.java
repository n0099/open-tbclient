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
    private static h dWq;

    public static h aDf() {
        if (dWq == null) {
            synchronized (h.class) {
                if (dWq == null) {
                    dWq = new h();
                }
            }
        }
        return dWq;
    }

    public void aDg() {
        SQLiteDatabase aDd = g.aDd();
        if (aDd != null) {
            if (aDd.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aDd.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aDd = g.aDd();
        if (aDd != null) {
            BdLog.i("begin commit transaction");
            if (aDd.inTransaction()) {
                try {
                    aDd.setTransactionSuccessful();
                    aDd.endTransaction();
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

    public boolean nt(String str) {
        SQLiteDatabase aDd = g.aDd();
        if (aDd == null) {
            return false;
        }
        try {
            aDd.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aDd = g.aDd();
        if (aDd == null) {
            return null;
        }
        try {
            return aDd.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean b(String str, String str2, String[] strArr) {
        SQLiteDatabase aDd = g.aDd();
        if (aDd == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aDd.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aDd = g.aDd();
        if (aDd == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aDd.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aDd = g.aDd();
        if (aDd == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aDd.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aDd;
        if (TextUtils.isEmpty(str) || (aDd = g.aDd()) == null) {
            return null;
        }
        try {
            return aDd.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
