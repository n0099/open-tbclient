package com.baidu.tieba.frs;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a {
    private static a azD;
    private b azE;
    private com.baidu.adp.lib.cache.t<byte[]> azF;

    private a() {
        this.azE = null;
        this.azF = null;
        this.azE = new b();
        this.azF = BdCacheService.cr().b("tb.frs.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public static synchronized a EV() {
        a aVar;
        synchronized (a.class) {
            if (azD == null) {
                azD = new a();
            }
            aVar = azD;
        }
        return aVar;
    }

    public boolean fd(String str) {
        if (this.azF != null && str != null) {
            byte[] bArr = this.azF.get(String.valueOf(TbadkApplication.getCurrentAccount()) + str);
            if (bArr != null && bArr.length > 0) {
                return this.azE.A(bArr) != null;
            }
        }
        return false;
    }

    public void a(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.azF.a(String.valueOf(TbadkApplication.getCurrentAccount()) + str, bArr, 604800000L);
                return;
            }
            this.azF.b(String.valueOf(TbadkApplication.getCurrentAccount()) + str, bArr, 604800000L);
        }
    }

    public void u(String str, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.azF.remove(String.valueOf(TbadkApplication.getCurrentAccount()) + str);
                return;
            }
            this.azF.H(String.valueOf(TbadkApplication.getCurrentAccount()) + str);
        }
    }

    public b getForumModel() {
        return this.azE;
    }

    public boolean isSameDay(String str) {
        com.baidu.adp.lib.cache.v<byte[]> G;
        if (str == null || str.length() <= 0 || (G = this.azF.G(str)) == null) {
            return false;
        }
        return UtilHelper.isSameDay(G.fN, System.currentTimeMillis());
    }
}
