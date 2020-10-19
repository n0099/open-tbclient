package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes23.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> ikq;

    public d() {
        aYK();
    }

    public void aYK() {
        if (this.ikq == null) {
            this.ikq = com.baidu.tbadk.core.c.a.bkE().AE("tb.forum_member_info");
        }
    }

    public byte[] Jq(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bB = this.ikq != null ? this.ikq.bB(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            aYK();
            this.ikq.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
