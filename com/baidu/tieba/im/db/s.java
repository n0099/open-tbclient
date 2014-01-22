package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.by;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class s {
    private static String a = null;
    private static volatile SQLiteDatabase b = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (s.class) {
            try {
            } catch (Exception e) {
                by.a(e, "ImDatabaseHelper.getImDataBase", new Object[0]);
                com.baidu.adp.lib.g.e.b("ImDatabaseHelper", "ImDatabaseHelper", "error = " + e.getMessage());
            }
            if (TextUtils.isEmpty(TiebaApplication.A())) {
                com.baidu.adp.lib.g.e.a("没有登录");
                sQLiteDatabase = null;
            } else {
                String str = TiebaApplication.A() + ".db";
                if (b != null && str.equals(a) && b.isOpen()) {
                    sQLiteDatabase = b;
                } else {
                    if (b != null) {
                        com.baidu.tieba.util.p.a(b);
                        com.baidu.adp.lib.g.e.b("读取数据文件错误或者没有打开或者要切换数据库，关闭当前数据库，重新开启。cur data：" + a + " should data:" + str);
                    }
                    r rVar = new r(TiebaApplication.h(), str);
                    a = str;
                    b = rVar.getWritableDatabase();
                    sQLiteDatabase = b;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> b() {
        Cursor cursor = null;
        SQLiteDatabase a2 = a();
        LinkedList<String> linkedList = new LinkedList<>();
        if (a2 != null) {
            try {
                cursor = a2.rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        linkedList.add(cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME)));
                    }
                }
            } catch (Exception e) {
                by.a(e, "ImDatabaseManager.getAllTables", new Object[0]);
                e.printStackTrace();
            } finally {
                com.baidu.tieba.util.p.a(cursor);
            }
        }
        com.baidu.adp.lib.g.e.d("haveTables:" + linkedList);
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
                        if (next.startsWith("tb_private_msg_")) {
                            String charSequence = next.subSequence("tb_private_msg_".length(), next.length()).toString();
                            com.baidu.adp.lib.g.e.d("see table id:" + charSequence + "name:" + next);
                            au.a().a(com.baidu.adp.lib.f.b.a(charSequence, 0L), true);
                        } else if (next.startsWith("tb_group_msg_")) {
                            SQLiteDatabase a3 = a();
                            if (a3 != null) {
                                com.baidu.adp.lib.g.e.d("DROP TABLE IF EXISTS " + next);
                                a3.execSQL("DROP TABLE IF EXISTS " + next);
                            }
                        } else if (!next.startsWith("tb_personal_id") && (a2 = a()) != null) {
                            com.baidu.adp.lib.g.e.d("CLEAR TABLE:" + next);
                            a2.delete(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            by.a(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        }
    }
}
