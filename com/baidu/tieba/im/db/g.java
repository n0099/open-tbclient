package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class g {
    private static String databaseName = null;
    private static volatile SQLiteDatabase database = null;
    public static HashMap<String, SQLiteDatabase> hzL = new HashMap<>();

    public static synchronized SQLiteDatabase bUJ() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (g.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.getImDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else {
                String str = TbadkCoreApplication.getCurrentAccount() + ".db";
                if (hzL.containsKey(str)) {
                    sQLiteDatabase = hzL.get(str);
                } else if (database != null && str.equals(databaseName) && database.isOpen()) {
                    sQLiteDatabase = database;
                } else {
                    if (database != null) {
                        com.baidu.adp.lib.util.n.close(database);
                    }
                    f fVar = new f(TbadkCoreApplication.getInst().getApp(), str);
                    databaseName = str;
                    database = fVar.getWritableDatabase();
                    sQLiteDatabase = database;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> bUK() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        SQLiteDatabase bUJ = bUJ();
        LinkedList<String> linkedList = new LinkedList<>();
        if (bUJ != null) {
            try {
                cursor2 = bUJ.rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor2 != null) {
                    try {
                        cursor2.moveToFirst();
                        while (cursor2.moveToNext()) {
                            linkedList.add(cursor2.getString(cursor2.getColumnIndex("name")));
                        }
                    } catch (Exception e) {
                        cursor = cursor2;
                        exc = e;
                        try {
                            TiebaStatic.printDBExceptionLog(exc, "ImDatabaseManager.getAllTables", new Object[0]);
                            exc.printStackTrace();
                            com.baidu.adp.lib.util.n.close(cursor);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            com.baidu.adp.lib.util.n.close(cursor);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor = cursor2;
                        th = th3;
                        com.baidu.adp.lib.util.n.close(cursor);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                cursor = null;
                exc = e2;
            } catch (Throwable th4) {
                cursor = null;
                th = th4;
            }
        }
        com.baidu.adp.lib.util.n.close(cursor2);
        return linkedList;
    }

    public static void CW(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                h.bUL().bUM();
                Iterator<String> it = bUK().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.equals("tb_message_center")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_hidden", (Integer) 1);
                            h.bUL().a("tb_message_center", contentValues, null, null);
                        } else if (!next.equals("tb_new_friends")) {
                            h.bUL().a(next, (String) null, (String[]) null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        } finally {
            h.bUL().bUN();
        }
    }
}
