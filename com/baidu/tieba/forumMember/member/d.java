package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes5.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> dqA;

    public d() {
        Wx();
    }

    public void Wx() {
        if (this.dqA == null) {
            this.dqA = com.baidu.tbadk.core.c.a.afD().mA("tb.forum_member_info");
        }
    }

    public byte[] we(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ap = this.dqA != null ? this.dqA.ap(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ap == null || ap.value == null) {
            return null;
        }
        return ap.value;
    }

    public void j(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            Wx();
            this.dqA.a(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
