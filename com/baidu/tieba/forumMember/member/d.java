package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> gjU;

    public d() {
        auV();
    }

    public void auV() {
        if (this.gjU == null) {
            this.gjU = com.baidu.tbadk.core.c.a.aEz().sP("tb.forum_member_info");
        }
    }

    public byte[] AT(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ad = this.gjU != null ? this.gjU.ad(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            auV();
            this.gjU.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
