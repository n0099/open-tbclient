package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> jdC;

    public c() {
        beu();
    }

    public void beu() {
        if (this.jdC == null) {
            this.jdC = com.baidu.tbadk.core.c.a.bqt().Ay("tb.forum_member_info");
        }
    }

    public byte[] Ke(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bC = this.jdC != null ? this.jdC.bC(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (bC == null || bC.value == null) {
            return null;
        }
        return bC.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            beu();
            this.jdC.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
