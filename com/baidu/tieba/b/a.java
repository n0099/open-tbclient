package com.baidu.tieba.b;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.q;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f949a = null;
    private q<String> b = null;
    private q<String> c = null;
    private q<String> d = null;
    private q<String> e = null;
    private q<String> f = null;
    private q<String> g = null;
    private q<String> h = null;
    private q<String> i = null;
    private q<String> j = null;
    private q<String> k = null;

    public static a a() {
        if (f949a == null) {
            f949a = new a();
        }
        return f949a;
    }

    private a() {
    }

    public q<String> b() {
        if (this.b == null) {
            this.b = BdCacheService.c().a("tb.pb_mark", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.b;
    }

    public q<String> c() {
        if (this.c == null) {
            this.c = BdCacheService.c().a("tb.pb_normal", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 1);
        }
        return this.c;
    }

    public q<String> d() {
        if (this.d == null) {
            this.d = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.d;
    }

    public q<String> e() {
        if (this.e == null) {
            this.e = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.e;
    }

    public q<String> f() {
        if (this.f == null) {
            this.f = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.f;
    }

    public q<String> g() {
        if (this.g == null) {
            this.g = BdCacheService.c().a("tb.my_bookmarks", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.g;
    }

    public q<String> h() {
        if (this.h == null) {
            this.h = BdCacheService.c().a("tb.my_posts", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.h;
    }

    public q<String> i() {
        if (this.i == null) {
            this.i = BdCacheService.c().a("tb.my_forums", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.i;
    }

    public q<String> j() {
        if (this.j == null) {
            this.j = BdCacheService.c().a("tb.square", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.j;
    }

    public q<String> k() {
        if (this.k == null) {
            this.k = BdCacheService.c().a("tb.first_dir", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.k;
    }
}
