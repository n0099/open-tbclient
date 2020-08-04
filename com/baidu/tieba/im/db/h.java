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
    private static h iXl;

    public static h ctm() {
        if (iXl == null) {
            synchronized (h.class) {
                if (iXl == null) {
                    iXl = new h();
                }
            }
        }
        return iXl;
    }

    public void ctn() {
        SQLiteDatabase ctk = g.ctk();
        if (ctk != null) {
            if (ctk.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                ctk.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cto() {
        SQLiteDatabase ctk = g.ctk();
        if (ctk != null) {
            BdLog.i("begin commit transaction");
            if (ctk.inTransaction()) {
                try {
                    ctk.setTransactionSuccessful();
                    ctk.endTransaction();
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

    public boolean HI(String str) {
        SQLiteDatabase ctk = g.ctk();
        if (ctk == null) {
            return false;
        }
        try {
            ctk.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase ctk = g.ctk();
        if (ctk == null) {
            return null;
        }
        try {
            return ctk.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase ctk = g.ctk();
        if (ctk == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return ctk.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase ctk = g.ctk();
        if (ctk == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return ctk.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase ctk = g.ctk();
        if (ctk == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return ctk.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement HJ(String str) {
        SQLiteDatabase ctk;
        if (TextUtils.isEmpty(str) || (ctk = g.ctk()) == null) {
            return null;
        }
        try {
            return ctk.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
