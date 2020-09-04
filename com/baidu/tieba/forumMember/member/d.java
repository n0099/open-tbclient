package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes17.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> hOr;

    public d() {
        aVq();
    }

    public void aVq() {
        if (this.hOr == null) {
            this.hOr = com.baidu.tbadk.core.c.a.bhb().zx("tb.forum_member_info");
        }
    }

    public byte[] Ig(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bz = this.hOr != null ? this.hOr.bz(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (bz == null || bz.value == null) {
            return null;
        }
        return bz.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            aVq();
            this.hOr.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
