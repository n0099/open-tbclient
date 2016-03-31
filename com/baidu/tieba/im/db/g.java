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
    private static g ceG;

    public static g aet() {
        if (ceG == null) {
            synchronized (g.class) {
                if (ceG == null) {
                    ceG = new g();
                }
            }
        }
        return ceG;
    }

    public void aeu() {
        SQLiteDatabase aer = f.aer();
        if (aer != null) {
            if (aer.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aer.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aer = f.aer();
        if (aer != null) {
            BdLog.i("begin commit transaction");
            if (aer.inTransaction()) {
                try {
                    aer.setTransactionSuccessful();
                    aer.endTransaction();
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

    public boolean jj(String str) {
        SQLiteDatabase aer = f.aer();
        if (aer == null) {
            return false;
        }
        try {
            aer.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aer = f.aer();
        if (aer == null) {
            return null;
        }
        try {
            return aer.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aer = f.aer();
        if (aer == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aer.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aer = f.aer();
        if (aer == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aer.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aer = f.aer();
        if (aer == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aer.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aer;
        if (TextUtils.isEmpty(str) || (aer = f.aer()) == null) {
            return null;
        }
        try {
            return aer.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
