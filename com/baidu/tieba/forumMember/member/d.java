package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> bmO;

    public d() {
        aoa();
    }

    public void aoa() {
        if (this.bmO == null) {
            this.bmO = com.baidu.tbadk.core.c.a.ty().cY("tb.forum_member_info");
        }
    }

    public byte[] lC(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ab = this.bmO != null ? this.bmO.ab(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ab == null || ab.value == null) {
            return null;
        }
        return ab.value;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            aoa();
            this.bmO.a(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
