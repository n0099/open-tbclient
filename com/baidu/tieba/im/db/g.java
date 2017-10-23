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
    private static g dsl;

    public static g ava() {
        if (dsl == null) {
            synchronized (g.class) {
                if (dsl == null) {
                    dsl = new g();
                }
            }
        }
        return dsl;
    }

    public void avb() {
        SQLiteDatabase auY = f.auY();
        if (auY != null) {
            if (auY.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                auY.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase auY = f.auY();
        if (auY != null) {
            BdLog.i("begin commit transaction");
            if (auY.inTransaction()) {
                try {
                    auY.setTransactionSuccessful();
                    auY.endTransaction();
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

    public boolean me(String str) {
        SQLiteDatabase auY = f.auY();
        if (auY == null) {
            return false;
        }
        try {
            auY.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase auY = f.auY();
        if (auY == null) {
            return null;
        }
        try {
            return auY.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase auY = f.auY();
        if (auY == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return auY.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase auY = f.auY();
        if (auY == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return auY.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase auY = f.auY();
        if (auY == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return auY.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase auY;
        if (TextUtils.isEmpty(str) || (auY = f.auY()) == null) {
            return null;
        }
        try {
            return auY.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
