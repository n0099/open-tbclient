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
    private static g aVs;

    public static g ME() {
        if (aVs == null) {
            synchronized (g.class) {
                if (aVs == null) {
                    aVs = new g();
                }
            }
        }
        return aVs;
    }

    public void MF() {
        SQLiteDatabase MC = f.MC();
        if (MC != null) {
            if (MC.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                MC.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase MC = f.MC();
        if (MC != null) {
            BdLog.i("begin commit transaction");
            if (MC.inTransaction()) {
                try {
                    MC.setTransactionSuccessful();
                    MC.endTransaction();
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

    public boolean gc(String str) {
        SQLiteDatabase MC = f.MC();
        if (MC == null) {
            return false;
        }
        try {
            MC.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase MC = f.MC();
        if (MC == null) {
            return null;
        }
        try {
            return MC.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase MC = f.MC();
        if (MC == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return MC.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase MC = f.MC();
        if (MC == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return MC.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase MC = f.MC();
        if (MC == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return MC.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase MC;
        if (TextUtils.isEmpty(str) || (MC = f.MC()) == null) {
            return null;
        }
        try {
            return MC.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
