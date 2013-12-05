package com.baidu.tieba.im.db;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bd;
import java.util.Iterator;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static String f1680a = null;
    private static volatile SQLiteDatabase b = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (s.class) {
            try {
            } catch (Exception e) {
                bd.b("ImDatabaseHelper", "ImDatabaseHelper", "error = " + e.getMessage());
            }
            if (TextUtils.isEmpty(TiebaApplication.B())) {
                bd.a("没有登录");
                sQLiteDatabase = null;
            } else {
                String str = TiebaApplication.B() + ".db";
                if (b != null && str.equals(f1680a) && b.isOpen()) {
                    sQLiteDatabase = b;
                } else {
                    if (b != null) {
                        com.baidu.tieba.util.o.a(b);
                        com.baidu.adp.lib.h.e.b("读取数据文件错误或者没有打开或者要切换数据库，关闭当前数据库，重新开启。cur data：" + f1680a + " should data:" + str);
                    }
                    r rVar = new r(TiebaApplication.h(), str);
                    f1680a = str;
                    b = rVar.getWritableDatabase();
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
        f1680a = null;
    }

    public static void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = str + ".db";
                if (b != null && str2.equals(f1680a)) {
                    com.baidu.tieba.util.o.a(b);
                }
                TiebaApplication.h().deleteDatabase(str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
