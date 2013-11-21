package com.baidu.tieba.b;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.s;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f1115a = null;
    private s<String> b = null;
    private s<String> c = null;
    private s<String> d = null;
    private s<String> e = null;
    private s<String> f = null;
    private s<String> g = null;
    private s<String> h = null;
    private s<String> i = null;
    private s<String> j = null;
    private s<String> k = null;
    private s<String> l = null;
    private s<byte[]> m = null;
    private s<byte[]> n = null;
    private s<byte[]> o = null;
    private s<String> p = null;
    private s<String> q = null;

    public static a a() {
        if (f1115a == null) {
            f1115a = new a();
        }
        return f1115a;
    }

    private a() {
    }

    public s<String> b() {
        if (this.b == null) {
            this.b = BdCacheService.c().a("tb.pb_mark", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.b;
    }

    public s<String> c() {
        if (this.d == null) {
            this.d = BdCacheService.c().a("tb.pb_normal", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 1);
        }
        return this.d;
    }

    public s<String> d() {
        if (this.c == null) {
            this.c = BdCacheService.c().a("tb.pb_editor", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.c;
    }

    public s<byte[]> e() {
        if (this.m == null) {
            this.m = BdCacheService.c().b("tb.im_frsgroup", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.m;
    }

    public s<String> f() {
        if (this.e == null) {
            this.e = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.e;
    }

    public s<String> g() {
        if (this.f == null) {
            this.f = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.f;
    }

    public s<String> h() {
        if (this.g == null) {
            this.g = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.g;
    }

    public s<String> i() {
        if (this.h == null) {
            this.h = BdCacheService.c().a("tb.my_bookmarks", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.h;
    }

    public s<String> j() {
        if (this.i == null) {
            this.i = BdCacheService.c().a("tb.my_posts", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.i;
    }

    public s<String> k() {
        if (this.j == null) {
            this.j = BdCacheService.c().a("tb.my_forums", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.j;
    }

    public s<String> l() {
        if (this.k == null) {
            this.k = BdCacheService.c().a("tb.square", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.k;
    }

    public s<String> m() {
        if (this.l == null) {
            this.l = BdCacheService.c().a("tb.first_dir", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.l;
    }

    public s<byte[]> n() {
        if (this.n == null) {
            this.n = BdCacheService.c().b("tb.im_groupinfo", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.n;
    }

    public s<byte[]> o() {
        if (this.o == null) {
            this.o = BdCacheService.c().b("tb.im_entergroup", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 10);
        }
        return this.o;
    }

    public s<String> p() {
        if (this.p == null) {
            this.p = BdCacheService.c().a("tb.im_group_setting", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 3);
        }
        return this.p;
    }

    public s<String> q() {
        if (this.q == null) {
            this.q = BdCacheService.c().a("tb.pic_gif", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.q;
    }
}
