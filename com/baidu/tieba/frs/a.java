package com.baidu.tieba.frs;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a {
    private static a azM;
    private b azN;
    private com.baidu.adp.lib.cache.t<byte[]> azO;

    private a() {
        this.azN = null;
        this.azO = null;
        this.azN = new b();
        this.azO = BdCacheService.cr().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized a EX() {
        a aVar;
        synchronized (a.class) {
            if (azM == null) {
                azM = new a();
            }
            aVar = azM;
        }
        return aVar;
    }

    public boolean fd(String str) {
        if (this.azO != null && str != null) {
            byte[] bArr = this.azO.get(String.valueOf(TbadkApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                return this.azN.A(bArr) != null;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.azO.a(String.valueOf(TbadkApplication.getCurrentAccount()) + str, bArr, 604800000L);
                return;
            }
            this.azO.b(String.valueOf(TbadkApplication.getCurrentAccount()) + str, bArr, 604800000L);
        }
    }

    public void u(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.azO.remove(String.valueOf(TbadkApplication.getCurrentAccount()) + str);
                return;
            }
            this.azO.H(String.valueOf(TbadkApplication.getCurrentAccount()) + str);
        }
    }

    public b getForumModel() {
        return this.azN;
    }

    public boolean isSameDay(String str) {
        com.baidu.adp.lib.cache.v<byte[]> G;
        if (str == null || str.length() <= 0 || (G = this.azO.G(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(G.fN, System.currentTimeMillis());
    }
}
