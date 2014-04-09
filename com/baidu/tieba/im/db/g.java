package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class g {
    private static String a = null;
    private static volatile SQLiteDatabase b = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (g.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.a(e, "ImDatabaseHelper.getImDataBase", new Object[0]);
                com.baidu.adp.lib.util.f.b("ImDatabaseHelper", "ImDatabaseHelper", "error = " + e.getMessage());
            }
            if (TextUtils.isEmpty(TbadkApplication.E())) {
                com.baidu.adp.lib.util.f.b("没有登录");
                sQLiteDatabase = null;
            } else {
                String str = String.valueOf(TbadkApplication.E()) + ".db";
                if (b != null && str.equals(a) && b.isOpen()) {
                    sQLiteDatabase = b;
                } else {
                    if (b != null) {
                        com.baidu.tbadk.core.util.l.a(b);
                        com.baidu.adp.lib.util.f.c("读取数据文件错误或者没有打开或者要切换数据库，关闭当前数据库，重新开启。cur data：" + a + " should data:" + str);
                    }
                    f fVar = new f(TbadkApplication.j().b(), str);
                    a = str;
                    b = fVar.getWritableDatabase();
                    sQLiteDatabase = b;
                }
            }
        }
        return sQLiteDatabase;
    }

    private static LinkedList<String> b() {
        Cursor cursor = null;
        SQLiteDatabase a2 = a();
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            if (a2 != null) {
                cursor = a2.rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        linkedList.add(cursor.getString(cursor.getColumnIndex("name")));
                    }
                }
            }
            com.baidu.adp.lib.util.f.e("haveTables:" + linkedList);
        } catch (Exception e) {
            TiebaStatic.a(e, "ImDatabaseManager.getAllTables", new Object[0]);
            e.printStackTrace();
        } finally {
            com.baidu.tbadk.core.util.l.a(cursor);
        }
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
                        if (next.startsWith(o.b)) {
                            String charSequence = next.subSequence(o.b.length(), next.length()).toString();
                            com.baidu.adp.lib.util.f.e("see table id:" + charSequence + "name:" + next);
                            o.d().a(com.baidu.adp.lib.f.b.a(charSequence, 0L), true);
                        } else if (next.startsWith("tb_group_msg_")) {
                            SQLiteDatabase a3 = a();
                            if (a3 != null) {
                                com.baidu.adp.lib.util.f.e("DROP TABLE IF EXISTS " + next);
                                a3.execSQL("DROP TABLE IF EXISTS " + next);
                            }
                        } else if (!next.startsWith("tb_personal_id") && (a2 = a()) != null) {
                            com.baidu.adp.lib.util.f.e("CLEAR TABLE:" + next);
                            a2.delete(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.a(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        }
    }
}
