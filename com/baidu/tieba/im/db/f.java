package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private static String nA = null;
    private static volatile SQLiteDatabase nw = null;
    public static HashMap<String, SQLiteDatabase> bcC = new HashMap<>();

    public static synchronized SQLiteDatabase PZ() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (f.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.getImDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else {
                String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + ".db";
                if (bcC.containsKey(str)) {
                    sQLiteDatabase = bcC.get(str);
                } else if (nw != null && str.equals(nA) && nw.isOpen()) {
                    sQLiteDatabase = nw;
                } else {
                    if (nw != null) {
                        v.i(nw);
                    }
                    e eVar = new e(TbadkCoreApplication.m411getInst().getApp(), str);
                    nA = str;
                    nw = eVar.getWritableDatabase();
                    sQLiteDatabase = nw;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> Qa() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        SQLiteDatabase PZ = PZ();
        LinkedList<String> linkedList = new LinkedList<>();
        if (PZ != null) {
            try {
                cursor2 = PZ.rawQuery("select * from sqlite_master where type='table'", null);
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
                            v.b(cursor);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            v.b(cursor);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor = cursor2;
                        th = th3;
                        v.b(cursor);
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
        v.b(cursor2);
        return linkedList;
    }

    public static void gz(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                g.Qb().Qc();
                Iterator<String> it = Qa().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.equals("tb_message_center")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_hidden", (Integer) 1);
                            g.Qb().update("tb_message_center", contentValues, null, null);
                        } else if (!next.equals("tb_new_friends")) {
                            g.Qb().a(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        } finally {
            g.Qb().endTransaction();
        }
    }
}
