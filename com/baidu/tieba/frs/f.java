package com.baidu.tieba.frs;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class f {
    private static f a;
    private g b;
    private com.baidu.adp.lib.cache.s<byte[]> c;

    private f() {
        this.b = null;
        this.c = null;
        this.b = new g();
        this.c = BdCacheService.c().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
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

    public boolean a(String str) {
        if (this.c != null && str != null) {
            byte[] a2 = this.c.a(String.valueOf(TbadkApplication.getCurrentAccount()) + str);
            if (a2 != null && a2.length > 0) {
                return this.b.a(a2) != null;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr) {
        if (str != null && str.length() > 0) {
            this.c.a(String.valueOf(TbadkApplication.getCurrentAccount()) + str, bArr, 604800000L);
        }
    }

    public void b(String str) {
        if (str != null && str.length() > 0) {
            this.c.c(String.valueOf(TbadkApplication.getCurrentAccount()) + str);
        }
    }

    public g b() {
        return this.b;
    }

    public boolean c(String str) {
        com.baidu.adp.lib.cache.t<byte[]> b;
        if (str == null || str.length() <= 0 || (b = this.c.b(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(b.c, System.currentTimeMillis());
    }
}
