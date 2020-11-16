package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes22.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> iDA;

    public d() {
        bcw();
    }

    public void bcw() {
        if (this.iDA == null) {
            this.iDA = com.baidu.tbadk.core.c.a.bob().AG("tb.forum_member_info");
        }
    }

    public byte[] JH(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bB = this.iDA != null ? this.iDA.bB(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            bcw();
            this.iDA.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
