package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> bwp;

    public d() {
        asq();
    }

    public void asq() {
        if (this.bwp == null) {
            this.bwp = com.baidu.tbadk.core.c.a.xj().dA("tb.forum_member_info");
        }
    }

    public byte[] mi(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> an = this.bwp != null ? this.bwp.an(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (an == null || an.value == null) {
            return null;
        }
        return an.value;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            asq();
            this.bwp.a(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
