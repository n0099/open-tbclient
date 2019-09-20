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
    private static h gHm;

    public static h bDI() {
        if (gHm == null) {
            synchronized (h.class) {
                if (gHm == null) {
                    gHm = new h();
                }
            }
        }
        return gHm;
    }

    public void bDJ() {
        SQLiteDatabase bDG = g.bDG();
        if (bDG != null) {
            if (bDG.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                bDG.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void bDK() {
        SQLiteDatabase bDG = g.bDG();
        if (bDG != null) {
            BdLog.i("begin commit transaction");
            if (bDG.inTransaction()) {
                try {
                    bDG.setTransactionSuccessful();
                    bDG.endTransaction();
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

    public boolean zw(String str) {
        SQLiteDatabase bDG = g.bDG();
        if (bDG == null) {
            return false;
        }
        try {
            bDG.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor b(String str, String[] strArr) {
        SQLiteDatabase bDG = g.bDG();
        if (bDG == null) {
            return null;
        }
        try {
            return bDG.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase bDG = g.bDG();
        if (bDG == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return bDG.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase bDG = g.bDG();
        if (bDG == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return bDG.update(str, contentValues, str2, strArr);
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

    public long a(String str, String str2, ContentValues contentValues) {
        SQLiteDatabase bDG = g.bDG();
        if (bDG == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return bDG.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement zx(String str) {
        SQLiteDatabase bDG;
        if (TextUtils.isEmpty(str) || (bDG = g.bDG()) == null) {
            return null;
        }
        try {
            return bDG.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
