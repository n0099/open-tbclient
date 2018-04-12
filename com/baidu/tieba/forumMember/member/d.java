package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> bmz;

    public d() {
        aob();
    }

    public void aob() {
        if (this.bmz == null) {
            this.bmz = com.baidu.tbadk.core.c.a.tz().cY("tb.forum_member_info");
        }
    }

    public byte[] lz(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ab = this.bmz != null ? this.bmz.ab(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ab == null || ab.value == null) {
            return null;
        }
        return ab.value;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            aob();
            this.bmz.a(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
