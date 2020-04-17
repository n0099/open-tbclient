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
    private static h ijA;

    public static h cfm() {
        if (ijA == null) {
            synchronized (h.class) {
                if (ijA == null) {
                    ijA = new h();
                }
            }
        }
        return ijA;
    }

    public void cfn() {
        SQLiteDatabase cfk = g.cfk();
        if (cfk != null) {
            if (cfk.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cfk.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cfo() {
        SQLiteDatabase cfk = g.cfk();
        if (cfk != null) {
            BdLog.i("begin commit transaction");
            if (cfk.inTransaction()) {
                try {
                    cfk.setTransactionSuccessful();
                    cfk.endTransaction();
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

    public boolean EG(String str) {
        SQLiteDatabase cfk = g.cfk();
        if (cfk == null) {
            return false;
        }
        try {
            cfk.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cfk = g.cfk();
        if (cfk == null) {
            return null;
        }
        try {
            return cfk.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase cfk = g.cfk();
        if (cfk == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cfk.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cfk = g.cfk();
        if (cfk == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cfk.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cfk = g.cfk();
        if (cfk == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cfk.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement EH(String str) {
        SQLiteDatabase cfk;
        if (TextUtils.isEmpty(str) || (cfk = g.cfk()) == null) {
            return null;
        }
        try {
            return cfk.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
