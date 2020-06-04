package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> hjb;

    public d() {
        aHS();
    }

    public void aHS() {
        if (this.hjb == null) {
            this.hjb = com.baidu.tbadk.core.c.a.aSS().vL("tb.forum_member_info");
        }
    }

    public byte[] Es(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bt = this.hjb != null ? this.hjb.bt(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (bt == null || bt.value == null) {
            return null;
        }
        return bt.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            aHS();
            this.hjb.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
