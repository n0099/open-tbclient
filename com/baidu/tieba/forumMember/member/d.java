package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes5.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> dsK;

    public d() {
        Xr();
    }

    public void Xr() {
        if (this.dsK == null) {
            this.dsK = com.baidu.tbadk.core.d.a.agF().mK("tb.forum_member_info");
        }
    }

    public byte[] wI(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> aq = this.dsK != null ? this.dsK.aq(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (aq == null || aq.value == null) {
            return null;
        }
        return aq.value;
    }

    public void j(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            Xr();
            this.dsK.a(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
