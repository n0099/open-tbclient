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
    private static h iQg;

    public static h cpH() {
        if (iQg == null) {
            synchronized (h.class) {
                if (iQg == null) {
                    iQg = new h();
                }
            }
        }
        return iQg;
    }

    public void cpI() {
        SQLiteDatabase cpF = g.cpF();
        if (cpF != null) {
            if (cpF.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                cpF.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cpJ() {
        SQLiteDatabase cpF = g.cpF();
        if (cpF != null) {
            BdLog.i("begin commit transaction");
            if (cpF.inTransaction()) {
                try {
                    cpF.setTransactionSuccessful();
                    cpF.endTransaction();
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

    public boolean GU(String str) {
        SQLiteDatabase cpF = g.cpF();
        if (cpF == null) {
            return false;
        }
        try {
            cpF.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase cpF = g.cpF();
        if (cpF == null) {
            return null;
        }
        try {
            return cpF.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase cpF = g.cpF();
        if (cpF == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return cpF.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase cpF = g.cpF();
        if (cpF == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return cpF.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase cpF = g.cpF();
        if (cpF == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return cpF.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement GV(String str) {
        SQLiteDatabase cpF;
        if (TextUtils.isEmpty(str) || (cpF = g.cpF()) == null) {
            return null;
        }
        try {
            return cpF.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
