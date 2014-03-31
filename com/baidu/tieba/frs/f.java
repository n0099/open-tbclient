package com.baidu.tieba.frs;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public final class f {
    private static f a;
    private g b;
    private com.baidu.adp.lib.cache.s<String> c;

    private f() {
        this.b = null;
        this.c = null;
        this.b = new g();
        this.c = BdCacheService.a().a("tb.frs", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f();
            }
            fVar = a;
        }
        return fVar;
    }

    public final boolean a(String str) {
        if (this.c != null && str != null) {
            String a2 = this.c.a(String.valueOf(TbadkApplication.E()) + str);
            if (a2 != null && a2.length() > 0) {
                this.b.a(a2);
                return true;
            }
        }
        return false;
    }

    public final void a(String str, String str2) {
        if (str != null && str.length() > 0) {
            this.c.a(String.valueOf(TbadkApplication.E()) + str, str2, 604800000L);
        }
    }

    public final void b(String str) {
        if (str != null && str.length() > 0) {
            this.c.c(String.valueOf(TbadkApplication.E()) + str);
        }
    }

    public final g b() {
        return this.b;
    }

    public final boolean c(String str) {
        com.baidu.adp.lib.cache.t<String> b;
        if (str == null || str.length() <= 0 || (b = this.c.b(str)) == null) {
            return false;
        }
        return UtilHelper.a(b.c, System.currentTimeMillis());
    }
}
