package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> aRx;
    private final long aRy = TbConfig.APP_OVERDUR_DRAFT_BOX;

    public a() {
        KG();
    }

    public void KG() {
        if (this.aRx == null) {
            this.aRx = com.baidu.tbadk.core.b.a.sM().cj("tb.forum_hot_thread");
        }
    }

    public byte[] gz(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.b<byte[]> ac = this.aRx != null ? this.aRx.ac(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ac == null || ac.so == null) {
            return null;
        }
        return ac.so;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            KG();
            this.aRx.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
