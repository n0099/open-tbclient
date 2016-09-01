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
    private static g cZb;

    public static g asj() {
        if (cZb == null) {
            synchronized (g.class) {
                if (cZb == null) {
                    cZb = new g();
                }
            }
        }
        return cZb;
    }

    public void ask() {
        SQLiteDatabase ash = f.ash();
        if (ash != null) {
            if (ash.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                ash.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase ash = f.ash();
        if (ash != null) {
            BdLog.i("begin commit transaction");
            if (ash.inTransaction()) {
                try {
                    ash.setTransactionSuccessful();
                    ash.endTransaction();
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

    public boolean lu(String str) {
        SQLiteDatabase ash = f.ash();
        if (ash == null) {
            return false;
        }
        try {
            ash.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase ash = f.ash();
        if (ash == null) {
            return null;
        }
        try {
            return ash.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase ash = f.ash();
        if (ash == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return ash.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase ash = f.ash();
        if (ash == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return ash.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase ash = f.ash();
        if (ash == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return ash.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase ash;
        if (TextUtils.isEmpty(str) || (ash = f.ash()) == null) {
            return null;
        }
        try {
            return ash.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
