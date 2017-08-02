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
    private static g dlv;

    public static g atJ() {
        if (dlv == null) {
            synchronized (g.class) {
                if (dlv == null) {
                    dlv = new g();
                }
            }
        }
        return dlv;
    }

    public void atK() {
        SQLiteDatabase atH = f.atH();
        if (atH != null) {
            if (atH.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                atH.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase atH = f.atH();
        if (atH != null) {
            BdLog.i("begin commit transaction");
            if (atH.inTransaction()) {
                try {
                    atH.setTransactionSuccessful();
                    atH.endTransaction();
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

    public boolean lV(String str) {
        SQLiteDatabase atH = f.atH();
        if (atH == null) {
            return false;
        }
        try {
            atH.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase atH = f.atH();
        if (atH == null) {
            return null;
        }
        try {
            return atH.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase atH = f.atH();
        if (atH == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return atH.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase atH = f.atH();
        if (atH == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return atH.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase atH = f.atH();
        if (atH == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return atH.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase atH;
        if (TextUtils.isEmpty(str) || (atH = f.atH()) == null) {
            return null;
        }
        try {
            return atH.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
