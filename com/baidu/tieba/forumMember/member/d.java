package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes22.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> hVr;

    public d() {
        aWc();
    }

    public void aWc() {
        if (this.hVr == null) {
            this.hVr = com.baidu.tbadk.core.c.a.bhV().zS("tb.forum_member_info");
        }
    }

    public byte[] ID(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bB = this.hVr != null ? this.hVr.bB(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            aWc();
            this.hVr.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
