package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private static String cp = null;
    private static volatile SQLiteDatabase cl = null;
    public static HashMap<String, SQLiteDatabase> aWJ = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase Mw() {
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
                if (aWJ.containsKey(str)) {
                    sQLiteDatabase = aWJ.get(str);
                } else if (cl != null && str.equals(cp) && cl.isOpen()) {
                    sQLiteDatabase = cl;
                } else {
                    if (cl != null) {
                        t.i(cl);
                    }
                    e eVar = new e(TbadkCoreApplication.m255getInst().getApp(), str);
                    cp = str;
                    cl = eVar.getWritableDatabase();
                    sQLiteDatabase = cl;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> Mx() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        SQLiteDatabase Mw = Mw();
        LinkedList<String> linkedList = new LinkedList<>();
        if (Mw != null) {
            try {
                cursor2 = Mw.rawQuery("select * from sqlite_master where type='table'", null);
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
                            t.b(cursor);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            t.b(cursor);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor = cursor2;
                        th = th3;
                        t.b(cursor);
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
        t.b(cursor2);
        return linkedList;
    }

    public static void gr(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                g.My().Mz();
                Iterator<String> it = Mx().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.equals("tb_message_center")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_hidden", (Integer) 1);
                            g.My().update("tb_message_center", contentValues, null, null);
                        } else if (!next.equals("tb_new_friends")) {
                            g.My().a(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        } finally {
            g.My().endTransaction();
        }
    }
}
