package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes23.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> iCL;

    public d() {
        bdd();
    }

    public void bdd() {
        if (this.iCL == null) {
            this.iCL = com.baidu.tbadk.core.c.a.boX().Bl("tb.forum_member_info");
        }
    }

    public byte[] Kg(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bB = this.iCL != null ? this.iCL.bB(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            bdd();
            this.iCL.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
