package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes17.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> hAW;

    public d() {
        aMQ();
    }

    public void aMQ() {
        if (this.hAW == null) {
            this.hAW = com.baidu.tbadk.core.c.a.aYG().xi("tb.forum_member_info");
        }
    }

    public byte[] FE(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bu = this.hAW != null ? this.hAW.bu(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (bu == null || bu.value == null) {
            return null;
        }
        return bu.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            aMQ();
            this.hAW.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
