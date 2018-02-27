package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> ccx;

    public d() {
        atL();
    }

    public void atL() {
        if (this.ccx == null) {
            this.ccx = com.baidu.tbadk.core.c.a.AQ().dg("tb.forum_member_info");
        }
    }

    public byte[] lw(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ae = this.ccx != null ? this.ccx.ae(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ae == null || ae.value == null) {
            return null;
        }
        return ae.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            atL();
            this.ccx.a(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
