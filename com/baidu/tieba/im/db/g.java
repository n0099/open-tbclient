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
    private static g bwH;

    public static g TJ() {
        if (bwH == null) {
            synchronized (g.class) {
                if (bwH == null) {
                    bwH = new g();
                }
            }
        }
        return bwH;
    }

    public void TK() {
        SQLiteDatabase TH = f.TH();
        if (TH != null) {
            if (TH.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                TH.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase TH = f.TH();
        if (TH != null) {
            BdLog.i("begin commit transaction");
            if (TH.inTransaction()) {
                try {
                    TH.setTransactionSuccessful();
                    TH.endTransaction();
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

    public boolean hP(String str) {
        SQLiteDatabase TH = f.TH();
        if (TH == null) {
            return false;
        }
        try {
            TH.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase TH = f.TH();
        if (TH == null) {
            return null;
        }
        try {
            return TH.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase TH = f.TH();
        if (TH == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return TH.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase TH = f.TH();
        if (TH == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return TH.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase TH = f.TH();
        if (TH == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return TH.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase TH;
        if (TextUtils.isEmpty(str) || (TH = f.TH()) == null) {
            return null;
        }
        try {
            return TH.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
