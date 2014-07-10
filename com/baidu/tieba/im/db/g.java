package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class g {
    private static String a = null;
    private static volatile SQLiteDatabase b = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (g.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.getImDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else {
                String str = String.valueOf(TbadkApplication.getCurrentAccount()) + ".db";
                if (b != null && str.equals(a) && b.isOpen()) {
                    sQLiteDatabase = b;
                } else {
                    if (b != null) {
                        com.baidu.adp.lib.util.m.a(b);
                    }
                    f fVar = new f(TbadkApplication.m252getInst().getApp(), str);
                    a = str;
                    b = fVar.getWritableDatabase();
                    sQLiteDatabase = b;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> b() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        SQLiteDatabase a2 = a();
        LinkedList<String> linkedList = new LinkedList<>();
        if (a2 != null) {
            try {
                cursor2 = a2.rawQuery("select * from sqlite_master where type='table'", null);
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
                            com.baidu.adp.lib.util.m.a(cursor);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            com.baidu.adp.lib.util.m.a(cursor);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor = cursor2;
                        th = th3;
                        com.baidu.adp.lib.util.m.a(cursor);
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
        com.baidu.adp.lib.util.m.a(cursor2);
        return linkedList;
    }

    public static void a(String str) {
        SQLiteDatabase a2;
        try {
            if (!TextUtils.isEmpty(str)) {
                Iterator<String> it = b().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.startsWith(p.b)) {
                            p.d().a(com.baidu.adp.lib.f.b.a(next.subSequence(p.b.length(), next.length()).toString(), 0L), true);
                        } else if (next.startsWith("tb_group_msg_")) {
                            SQLiteDatabase a3 = a();
                            if (a3 != null) {
                                a3.execSQL("DROP TABLE IF EXISTS " + next);
                            }
                        } else if (!next.startsWith("tb_personal_id") && (a2 = a()) != null) {
                            a2.delete(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        }
    }
}
