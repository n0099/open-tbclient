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
    private static g a;

    public static g a() {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g();
                }
            }
        }
        return a;
    }

    public void b() {
        SQLiteDatabase a2 = f.a();
        if (a2 != null) {
            if (a2.inTransaction()) {
                BdLog.e("there is exist transaction");
                return;
            }
            try {
                a2.beginTransaction();
                BdLog.i("db.beginTransaction");
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void c() {
        SQLiteDatabase a2 = f.a();
        if (a2 != null) {
            BdLog.i("begin commit transaction");
            if (a2.inTransaction()) {
                try {
                    a2.setTransactionSuccessful();
                    a2.endTransaction();
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

    public boolean a(String str) {
        SQLiteDatabase a2 = f.a();
        if (a2 == null) {
            return false;
        }
        try {
            a2.execSQL(str);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public Cursor a(String str, String[] strArr) {
        SQLiteDatabase a2 = f.a();
        if (a2 == null) {
            return null;
        }
        try {
            return a2.rawQuery(str, strArr);
        } catch (Exception e) {
            BdLog.e(String.valueOf(e.getMessage()) + str);
            return null;
        }
    }

    public boolean a(String str, String str2, String[] strArr) {
        SQLiteDatabase a2 = f.a();
        if (a2 == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return a2.delete(str, str2, strArr) > 0;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        SQLiteDatabase a2 = f.a();
        if (a2 == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return a2.update(str, contentValues, str2, strArr);
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
        SQLiteDatabase a2 = f.a();
        if (a2 == null || TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return a2.insert(str, str2, contentValues);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1L;
        }
    }

    public SQLiteStatement b(String str) {
        SQLiteDatabase a2;
        if (TextUtils.isEmpty(str) || (a2 = f.a()) == null) {
            return null;
        }
        try {
            return a2.compileStatement(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
