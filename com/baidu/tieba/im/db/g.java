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
    private static g cNw;

    public static g anu() {
        if (cNw == null) {
            synchronized (g.class) {
                if (cNw == null) {
                    cNw = new g();
                }
            }
        }
        return cNw;
    }

    public void anv() {
        SQLiteDatabase ans = f.ans();
        if (ans != null) {
            if (ans.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                ans.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase ans = f.ans();
        if (ans != null) {
            BdLog.i("begin commit transaction");
            if (ans.inTransaction()) {
                try {
                    ans.setTransactionSuccessful();
                    ans.endTransaction();
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

    public boolean kL(String str) {
        SQLiteDatabase ans = f.ans();
        if (ans == null) {
            return false;
        }
        try {
            ans.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase ans = f.ans();
        if (ans == null) {
            return null;
        }
        try {
            return ans.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase ans = f.ans();
        if (ans == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return ans.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase ans = f.ans();
        if (ans == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return ans.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase ans = f.ans();
        if (ans == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return ans.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase ans;
        if (TextUtils.isEmpty(str) || (ans = f.ans()) == null) {
            return null;
        }
        try {
            return ans.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
