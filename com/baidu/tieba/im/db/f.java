package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private static String nb = null;
    private static volatile SQLiteDatabase mV = null;
    public static HashMap<String, SQLiteDatabase> dsx = new HashMap<>();

    public static synchronized SQLiteDatabase avd() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (f.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.getImDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else {
                String str = TbadkCoreApplication.getCurrentAccount() + ".db";
                if (dsx.containsKey(str)) {
                    sQLiteDatabase = dsx.get(str);
                } else if (mV != null && str.equals(nb) && mV.isOpen()) {
                    sQLiteDatabase = mV;
                } else {
                    if (mV != null) {
                        n.i(mV);
                    }
                    e eVar = new e(TbadkCoreApplication.getInst().getApp(), str);
                    nb = str;
                    mV = eVar.getWritableDatabase();
                    sQLiteDatabase = mV;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> ave() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        SQLiteDatabase avd = avd();
        LinkedList<String> linkedList = new LinkedList<>();
        if (avd != null) {
            try {
                cursor2 = avd.rawQuery("select * from sqlite_master where type='table'", null);
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
                            n.e(cursor);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            n.e(cursor);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor = cursor2;
                        th = th3;
                        n.e(cursor);
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
        n.e(cursor2);
        return linkedList;
    }

    public static void me(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                g.avf().avg();
                Iterator<String> it = ave().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.equals("tb_message_center")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_hidden", (Integer) 1);
                            g.avf().update("tb_message_center", contentValues, null, null);
                        } else if (!next.equals("tb_new_friends")) {
                            g.avf().a(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        } finally {
            g.avf().endTransaction();
        }
    }
}
