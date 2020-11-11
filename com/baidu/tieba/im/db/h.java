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
    private static h kcm;

    public static h cRb() {
        if (kcm == null) {
            synchronized (h.class) {
                if (kcm == null) {
                    kcm = new h();
                }
            }
        }
        return kcm;
    }

    public void cRc() {
        SQLiteDatabase cQZ = g.cQZ();
        if (cQZ != null) {
            if (cQZ.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cQZ.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cRd() {
        SQLiteDatabase cQZ = g.cQZ();
        if (cQZ != null) {
            BdLog.i("begin commit transaction");
            if (cQZ.inTransaction()) {
                try {
                    cQZ.setTransactionSuccessful();
                    cQZ.endTransaction();
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

    public boolean MH(String str) {
        SQLiteDatabase cQZ = g.cQZ();
        if (cQZ == null) {
            return false;
        }
        try {
            cQZ.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cQZ = g.cQZ();
        if (cQZ == null) {
            return null;
        }
        try {
            return cQZ.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase cQZ = g.cQZ();
        if (cQZ == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cQZ.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cQZ = g.cQZ();
        if (cQZ == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cQZ.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cQZ = g.cQZ();
        if (cQZ == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cQZ.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement MI(String str) {
        SQLiteDatabase cQZ;
        if (TextUtils.isEmpty(str) || (cQZ = g.cQZ()) == null) {
            return null;
        }
        try {
            return cQZ.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
