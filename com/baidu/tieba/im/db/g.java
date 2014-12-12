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
    private static g aWK;

    public static g My() {
        if (aWK == null) {
            synchronized (g.class) {
                if (aWK == null) {
                    aWK = new g();
                }
            }
        }
        return aWK;
    }

    public void Mz() {
        SQLiteDatabase Mw = f.Mw();
        if (Mw != null) {
            if (Mw.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                Mw.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase Mw = f.Mw();
        if (Mw != null) {
            BdLog.i("begin commit transaction");
            if (Mw.inTransaction()) {
                try {
                    Mw.setTransactionSuccessful();
                    Mw.endTransaction();
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

    public boolean gs(String str) {
        SQLiteDatabase Mw = f.Mw();
        if (Mw == null) {
            return false;
        }
        try {
            Mw.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase Mw = f.Mw();
        if (Mw == null) {
            return null;
        }
        try {
            return Mw.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase Mw = f.Mw();
        if (Mw == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Mw.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase Mw = f.Mw();
        if (Mw == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Mw.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase Mw = f.Mw();
        if (Mw == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Mw.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase Mw;
        if (TextUtils.isEmpty(str) || (Mw = f.Mw()) == null) {
            return null;
        }
        try {
            return Mw.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
