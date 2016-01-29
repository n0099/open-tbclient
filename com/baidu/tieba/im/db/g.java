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
    private static g bUd;

    public static g aaX() {
        if (bUd == null) {
            synchronized (g.class) {
                if (bUd == null) {
                    bUd = new g();
                }
            }
        }
        return bUd;
    }

    public void aaY() {
        SQLiteDatabase aaV = f.aaV();
        if (aaV != null) {
            if (aaV.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aaV.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aaV = f.aaV();
        if (aaV != null) {
            BdLog.i("begin commit transaction");
            if (aaV.inTransaction()) {
                try {
                    aaV.setTransactionSuccessful();
                    aaV.endTransaction();
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

    public boolean iA(String str) {
        SQLiteDatabase aaV = f.aaV();
        if (aaV == null) {
            return false;
        }
        try {
            aaV.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aaV = f.aaV();
        if (aaV == null) {
            return null;
        }
        try {
            return aaV.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aaV = f.aaV();
        if (aaV == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aaV.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aaV = f.aaV();
        if (aaV == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aaV.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aaV = f.aaV();
        if (aaV == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aaV.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aaV;
        if (TextUtils.isEmpty(str) || (aaV = f.aaV()) == null) {
            return null;
        }
        try {
            return aaV.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
