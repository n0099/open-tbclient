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
    private static h iyo;

    public static h clI() {
        if (iyo == null) {
            synchronized (h.class) {
                if (iyo == null) {
                    iyo = new h();
                }
            }
        }
        return iyo;
    }

    public void clJ() {
        SQLiteDatabase clG = g.clG();
        if (clG != null) {
            if (clG.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                clG.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void clK() {
        SQLiteDatabase clG = g.clG();
        if (clG != null) {
            BdLog.i("begin commit transaction");
            if (clG.inTransaction()) {
                try {
                    clG.setTransactionSuccessful();
                    clG.endTransaction();
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

    public boolean Gs(String str) {
        SQLiteDatabase clG = g.clG();
        if (clG == null) {
            return false;
        }
        try {
            clG.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase clG = g.clG();
        if (clG == null) {
            return null;
        }
        try {
            return clG.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase clG = g.clG();
        if (clG == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return clG.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase clG = g.clG();
        if (clG == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return clG.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase clG = g.clG();
        if (clG == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return clG.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement Gt(String str) {
        SQLiteDatabase clG;
        if (TextUtils.isEmpty(str) || (clG = g.clG()) == null) {
            return null;
        }
        try {
            return clG.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
