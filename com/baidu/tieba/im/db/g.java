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
    private static g dwi;

    public static g awu() {
        if (dwi == null) {
            synchronized (g.class) {
                if (dwi == null) {
                    dwi = new g();
                }
            }
        }
        return dwi;
    }

    public void awv() {
        SQLiteDatabase aws = f.aws();
        if (aws != null) {
            if (aws.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                aws.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void endTransaction() {
        SQLiteDatabase aws = f.aws();
        if (aws != null) {
            BdLog.i("begin commit transaction");
            if (aws.inTransaction()) {
                try {
                    aws.setTransactionSuccessful();
                    aws.endTransaction();
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

    public boolean mB(String str) {
        SQLiteDatabase aws = f.aws();
        if (aws == null) {
            return false;
        }
        try {
            aws.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        SQLiteDatabase aws = f.aws();
        if (aws == null) {
            return null;
        }
        try {
            return aws.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(e.getMessage() + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase aws = f.aws();
        if (aws == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return aws.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase aws = f.aws();
        if (aws == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return aws.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase aws = f.aws();
        if (aws == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return aws.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement compileStatement(String str) {
        SQLiteDatabase aws;
        if (TextUtils.isEmpty(str) || (aws = f.aws()) == null) {
            return null;
        }
        try {
            return aws.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
