package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes5.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> duC;

    public d() {
        Xv();
    }

    public void Xv() {
        if (this.duC == null) {
            this.duC = com.baidu.tbadk.core.d.a.agL().mM("tb.forum_member_info");
        }
    }

    public byte[] xi(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> aq = this.duC != null ? this.duC.aq(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (aq == null || aq.value == null) {
            return null;
        }
        return aq.value;
    }

    public void j(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            Xv();
            this.duC.a(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
