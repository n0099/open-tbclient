package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> bBh;

    public a() {
        Vc();
    }

    public void Vc() {
        if (this.bBh == null) {
            this.bBh = com.baidu.tbadk.core.b.a.rO().cv("tb.forum_hot_thread");
        }
    }

    public byte[] iT(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.c<byte[]> S = this.bBh != null ? this.bBh.S(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (S == null || S.iZ == null) {
            return null;
        }
        return S.iZ;
    }

    public void j(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            Vc();
            this.bBh.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
