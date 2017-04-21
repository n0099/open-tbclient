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
    private static g cVt;

    public static g aqz() {
        if (cVt == null) {
            synchronized (g.class) {
                if (cVt == null) {
                    cVt = new g();
                }
            }
        }
        return cVt;
    }

    public void aqA() {
        SQLiteDatabase aqx = f.aqx();
        if (aqx != null) {
            if (aqx.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aqx.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aqx = f.aqx();
        if (aqx != null) {
            BdLog.i("begin commit transaction");
            if (aqx.inTransaction()) {
                try {
                    aqx.setTransactionSuccessful();
                    aqx.endTransaction();
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

    public boolean kt(String str) {
        SQLiteDatabase aqx = f.aqx();
        if (aqx == null) {
            return false;
        }
        try {
            aqx.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aqx = f.aqx();
        if (aqx == null) {
            return null;
        }
        try {
            return aqx.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aqx = f.aqx();
        if (aqx == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aqx.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aqx = f.aqx();
        if (aqx == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aqx.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aqx = f.aqx();
        if (aqx == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aqx.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aqx;
        if (TextUtils.isEmpty(str) || (aqx = f.aqx()) == null) {
            return null;
        }
        try {
            return aqx.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
