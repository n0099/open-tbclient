package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes8.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> ghT;

    public d() {
        asH();
    }

    public void asH() {
        if (this.ghT == null) {
            this.ghT = com.baidu.tbadk.core.c.a.aCo().sz("tb.forum_member_info");
        }
    }

    public byte[] AD(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ad = this.ghT != null ? this.ghT.ad(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            asH();
            this.ghT.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
