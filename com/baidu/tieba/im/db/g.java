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
    private static g exo;

    public static g aGG() {
        if (exo == null) {
            synchronized (g.class) {
                if (exo == null) {
                    exo = new g();
                }
            }
        }
        return exo;
    }

    public void aGH() {
        SQLiteDatabase aGE = f.aGE();
        if (aGE != null) {
            if (aGE.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aGE.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aGE = f.aGE();
        if (aGE != null) {
            BdLog.i("begin commit transaction");
            if (aGE.inTransaction()) {
                try {
                    aGE.setTransactionSuccessful();
                    aGE.endTransaction();
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

    public boolean ne(String str) {
        SQLiteDatabase aGE = f.aGE();
        if (aGE == null) {
            return false;
        }
        try {
            aGE.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aGE = f.aGE();
        if (aGE == null) {
            return null;
        }
        try {
            return aGE.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aGE = f.aGE();
        if (aGE == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aGE.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aGE = f.aGE();
        if (aGE == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aGE.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aGE = f.aGE();
        if (aGE == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aGE.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aGE;
        if (TextUtils.isEmpty(str) || (aGE = f.aGE()) == null) {
            return null;
        }
        try {
            return aGE.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
