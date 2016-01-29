package com.baidu.tieba.frs.hot;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private o<byte[]> bct;

    public a() {
        Oi();
    }

    public void Oi() {
        if (this.bct == null) {
            this.bct = com.baidu.tbadk.core.b.a.ug().cA("tb.forum_hot_thread");
        }
    }

    public byte[] hm(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        o.b<byte[]> Z = this.bct != null ? this.bct.Z(String.valueOf(str) + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (Z == null || Z.sz == null) {
            return null;
        }
        return Z.sz;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            Oi();
            this.bct.a(String.valueOf(str) + "/" + currentAccount, bArr, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }
}
