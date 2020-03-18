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
    private static h hzM;

    public static h bUL() {
        if (hzM == null) {
            synchronized (h.class) {
                if (hzM == null) {
                    hzM = new h();
                }
            }
        }
        return hzM;
    }

    public void bUM() {
        SQLiteDatabase bUJ = g.bUJ();
        if (bUJ != null) {
            if (bUJ.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bUJ.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bUN() {
        SQLiteDatabase bUJ = g.bUJ();
        if (bUJ != null) {
            BdLog.i("begin commit transaction");
            if (bUJ.inTransaction()) {
                try {
                    bUJ.setTransactionSuccessful();
                    bUJ.endTransaction();
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

    public boolean CX(String str) {
        SQLiteDatabase bUJ = g.bUJ();
        if (bUJ == null) {
            return false;
        }
        try {
            bUJ.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase bUJ = g.bUJ();
        if (bUJ == null) {
            return null;
        }
        try {
            return bUJ.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bUJ = g.bUJ();
        if (bUJ == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bUJ.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bUJ = g.bUJ();
        if (bUJ == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bUJ.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase bUJ = g.bUJ();
        if (bUJ == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bUJ.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement CY(String str) {
        SQLiteDatabase bUJ;
        if (TextUtils.isEmpty(str) || (bUJ = g.bUJ()) == null) {
            return null;
        }
        try {
            return bUJ.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
