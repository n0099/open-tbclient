package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes5.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> dqB;

    public d() {
        Wx();
    }

    public void Wx() {
        if (this.dqB == null) {
            this.dqB = com.baidu.tbadk.core.c.a.afD().mA("tb.forum_member_info");
        }
    }

    public byte[] we(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ap = this.dqB != null ? this.dqB.ap(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ap == null || ap.value == null) {
            return null;
        }
        return ap.value;
    }

    public void j(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            Wx();
            this.dqB.a(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
