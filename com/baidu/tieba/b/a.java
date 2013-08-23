package com.baidu.tieba.b;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.q;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f932a = null;
    private q b = null;
    private q c = null;
    private q d = null;
    private q e = null;
    private q f = null;
    private q g = null;
    private q h = null;
    private q i = null;
    private q j = null;
    private q k = null;

    public static a a() {
        if (f932a == null) {
            f932a = new a();
        }
        return f932a;
    }

    private a() {
    }

    public q b() {
        if (this.b == null) {
            this.b = BdCacheService.c().a("tb.pb_mark", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 50);
        }
        return this.b;
    }

    public q c() {
        if (this.c == null) {
            this.c = BdCacheService.c().a("tb.pb_normal", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 1);
        }
        return this.c;
    }

    public q d() {
        if (this.d == null) {
            this.d = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.d;
    }

    public q e() {
        if (this.e == null) {
            this.e = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.e;
    }

    public q f() {
        if (this.f == null) {
            this.f = BdCacheService.c().a("tb.my_pages", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 5);
        }
        return this.f;
    }

    public q g() {
        if (this.g == null) {
            this.g = BdCacheService.c().a("tb.my_bookmarks", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.g;
    }

    public q h() {
        if (this.h == null) {
            this.h = BdCacheService.c().a("tb.my_posts", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.h;
    }

    public q i() {
        if (this.i == null) {
            this.i = BdCacheService.c().a("tb.my_forums", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 3);
        }
        return this.i;
    }

    public q j() {
        if (this.j == null) {
            this.j = BdCacheService.c().a("tb.square", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.j;
    }

    public q k() {
        if (this.k == null) {
            this.k = BdCacheService.c().a("tb.first_dir", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
        }
        return this.k;
    }
}
