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
    private static g aVe;

    public static g MA() {
        if (aVe == null) {
            synchronized (g.class) {
                if (aVe == null) {
                    aVe = new g();
                }
            }
        }
        return aVe;
    }

    public void MB() {
        SQLiteDatabase My = f.My();
        if (My != null) {
            if (My.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                My.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase My = f.My();
        if (My != null) {
            BdLog.i("begin commit transaction");
            if (My.inTransaction()) {
                try {
                    My.setTransactionSuccessful();
                    My.endTransaction();
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
        SQLiteDatabase My = f.My();
        if (My == null) {
            return false;
        }
        try {
            My.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase My = f.My();
        if (My == null) {
            return null;
        }
        try {
            return My.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase My = f.My();
        if (My == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return My.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase My = f.My();
        if (My == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return My.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase My = f.My();
        if (My == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return My.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase My;
        if (TextUtils.isEmpty(str) || (My = f.My()) == null) {
            return null;
        }
        try {
            return My.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
