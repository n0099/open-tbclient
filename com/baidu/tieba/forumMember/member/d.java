package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> bPR;

    public d() {
        azl();
    }

    public void azl() {
        if (this.bPR == null) {
            this.bPR = com.baidu.tbadk.core.c.a.BB().ex("tb.forum_member_info");
        }
    }

    public byte[] nN(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> aF = this.bPR != null ? this.bPR.aF(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            azl();
            this.bPR.a(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
