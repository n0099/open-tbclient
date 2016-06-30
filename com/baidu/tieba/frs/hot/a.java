package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> byT;

    public a() {
        Uu();
    }

    public void Uu() {
        if (this.byT == null) {
            this.byT = com.baidu.tbadk.core.b.a.rP().cv("tb.forum_hot_thread");
        }
    }

    public byte[] iN(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.b<byte[]> Q = this.byT != null ? this.byT.Q(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (Q == null || Q.ix == null) {
            return null;
        }
        return Q.ix;
    }

    public void j(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            Uu();
            this.byT.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
