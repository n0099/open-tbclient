package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> iVY;

    public c() {
        bef();
    }

    public void bef() {
        if (this.iVY == null) {
            this.iVY = com.baidu.tbadk.core.c.a.bpZ().Aa("tb.forum_member_info");
        }
    }

    public byte[] Jj(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> by = this.iVY != null ? this.iVY.by(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (by == null || by.value == null) {
            return null;
        }
        return by.value;
    }

    public void m(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            bef();
            this.iVY.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
