package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> gjW;

    public d() {
        auX();
    }

    public void auX() {
        if (this.gjW == null) {
            this.gjW = com.baidu.tbadk.core.c.a.aEB().sP("tb.forum_member_info");
        }
    }

    public byte[] AT(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ad = this.gjW != null ? this.gjW.ad(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            auX();
            this.gjW.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
