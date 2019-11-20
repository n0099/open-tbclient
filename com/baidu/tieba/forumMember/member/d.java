package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes5.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> fqn;

    public d() {
        aci();
    }

    public void aci() {
        if (this.fqn == null) {
            this.fqn = com.baidu.tbadk.core.d.a.akL().nk("tb.forum_member_info");
        }
    }

    public byte[] vB(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> Y = this.fqn != null ? this.fqn.Y(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (Y == null || Y.value == null) {
            return null;
        }
        return Y.value;
    }

    public void i(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            aci();
            this.fqn.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
