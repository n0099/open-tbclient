package com.baidu.tieba.d;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bp;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String e() {
        return "key_baobao_count" + TbadkApplication.getCurrentAccount();
    }

    private static String f() {
        return "key_baobao_last_time" + TbadkApplication.getCurrentAccount();
    }

    public static boolean a() {
        return !bp.b(new Date(System.currentTimeMillis()), new Date(com.baidu.tbadk.core.sharedPref.b.a().a(f(), 0L))) || com.baidu.tbadk.core.sharedPref.b.a().a(e(), 0) < 3;
    }

    public static boolean b() {
        return !com.baidu.tbadk.core.sharedPref.b.a().a("key_baobao_tip_pb", false);
    }

    public static void c() {
        com.baidu.tbadk.core.sharedPref.b.a().c("key_baobao_tip_pb", true);
    }

    public static void d() {
        long currentTimeMillis = System.currentTimeMillis();
        long a = com.baidu.tbadk.core.sharedPref.b.a().a(f(), 0L);
        com.baidu.tbadk.core.sharedPref.b.a().b(f(), currentTimeMillis);
        int a2 = com.baidu.tbadk.core.sharedPref.b.a().a(e(), 0);
        if (bp.b(new Date(currentTimeMillis), new Date(a))) {
            com.baidu.tbadk.core.sharedPref.b.a().b(e(), a2 + 1);
        } else {
            com.baidu.tbadk.core.sharedPref.b.a().b(e(), 1);
        }
    }
}
