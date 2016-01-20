package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> bae;

    public a() {
        Mp();
    }

    public void Mp() {
        if (this.bae == null) {
            this.bae = com.baidu.tbadk.core.b.a.tc().cB("tb.forum_hot_thread");
        }
    }

    public byte[] hm(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.b<byte[]> aa = this.bae != null ? this.bae.aa(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (aa == null || aa.sq == null) {
            return null;
        }
        return aa.sq;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            Mp();
            this.bae.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
