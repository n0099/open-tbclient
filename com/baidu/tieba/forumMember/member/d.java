package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> gkj;

    public d() {
        auX();
    }

    public void auX() {
        if (this.gkj == null) {
            this.gkj = com.baidu.tbadk.core.c.a.aEB().sP("tb.forum_member_info");
        }
    }

    public byte[] AU(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ad = this.gkj != null ? this.gkj.ad(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            auX();
            this.gkj.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
