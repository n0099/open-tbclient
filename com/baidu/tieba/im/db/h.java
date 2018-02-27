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
    private static h eBz;

    public static h aIf() {
        if (eBz == null) {
            synchronized (h.class) {
                if (eBz == null) {
                    eBz = new h();
                }
            }
        }
        return eBz;
    }

    public void aIg() {
        SQLiteDatabase aId = g.aId();
        if (aId != null) {
            if (aId.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aId.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aId = g.aId();
        if (aId != null) {
            BdLog.i("begin commit transaction");
            if (aId.inTransaction()) {
                try {
                    aId.setTransactionSuccessful();
                    aId.endTransaction();
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

    public boolean np(String str) {
        SQLiteDatabase aId = g.aId();
        if (aId == null) {
            return false;
        }
        try {
            aId.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aId = g.aId();
        if (aId == null) {
            return null;
        }
        try {
            return aId.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aId = g.aId();
        if (aId == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aId.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aId = g.aId();
        if (aId == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aId.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aId = g.aId();
        if (aId == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aId.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aId;
        if (TextUtils.isEmpty(str) || (aId = g.aId()) == null) {
            return null;
        }
        try {
            return aId.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
