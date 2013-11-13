package com.baidu.tieba.im.db;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bg;
import java.util.Iterator;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static String f1620a = null;
    private static volatile SQLiteDatabase b = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (m.class) {
            try {
            } catch (Exception e) {
                bg.b("ImDatabaseHelper", "ImDatabaseHelper", "error = " + e.getMessage());
            }
            if (TextUtils.isEmpty(TiebaApplication.A())) {
                bg.a("没有登录");
                sQLiteDatabase = null;
            } else {
                String str = TiebaApplication.A() + ".db";
                if (b != null && str.equals(f1620a) && b.isOpen()) {
                    sQLiteDatabase = b;
                } else {
                    if (b != null) {
                        com.baidu.tieba.util.o.a(b);
                        com.baidu.adp.lib.h.d.b("读取数据文件错误或者没有打开或者要切换数据库，关闭当前数据库，重新开启。cur data：" + f1620a + " should data:" + str);
                    }
                    l lVar = new l(TiebaApplication.g(), str);
                    f1620a = str;
                    b = lVar.getWritableDatabase();
                    sQLiteDatabase = b;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static void b() {
        com.baidu.tieba.util.o.a(b);
        Iterator<AccountData> it = DatabaseService.l().iterator();
        while (it.hasNext()) {
            a(it.next().getID());
        }
        b = null;
        f1620a = null;
    }

    public static void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = str + ".db";
                if (b != null && str2.equals(f1620a)) {
                    com.baidu.tieba.util.o.a(b);
                }
                TiebaApplication.g().deleteDatabase(str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
