package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes23.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> iOs;

    public d() {
        bfB();
    }

    public void bfB() {
        if (this.iOs == null) {
            this.iOs = com.baidu.tbadk.core.c.a.brq().Bn("tb.forum_member_info");
        }
    }

    public byte[] Kx(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bE = this.iOs != null ? this.iOs.bE(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (bE == null || bE.value == null) {
            return null;
        }
        return bE.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            bfB();
            this.iOs.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
