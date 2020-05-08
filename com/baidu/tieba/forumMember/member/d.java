package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> gUe;

    public d() {
        aDl();
    }

    public void aDl() {
        if (this.gUe == null) {
            this.gUe = com.baidu.tbadk.core.c.a.aMR().uf("tb.forum_member_info");
        }
    }

    public byte[] CJ(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bs = this.gUe != null ? this.gUe.bs(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (bs == null || bs.value == null) {
            return null;
        }
        return bs.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            aDl();
            this.gUe.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
