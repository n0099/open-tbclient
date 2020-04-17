package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> gTY;

    public d() {
        aDl();
    }

    public void aDl() {
        if (this.gTY == null) {
            this.gTY = com.baidu.tbadk.core.c.a.aMT().uc("tb.forum_member_info");
        }
    }

    public byte[] CG(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bs = this.gTY != null ? this.gTY.bs(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (bs == null || bs.value == null) {
            return null;
        }
        return bs.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            aDl();
            this.gTY.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
