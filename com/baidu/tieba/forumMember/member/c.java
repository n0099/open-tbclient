package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes8.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> jbT;

    public c() {
        bes();
    }

    public void bes() {
        if (this.jbT == null) {
            this.jbT = com.baidu.tbadk.core.c.a.bqr().Ar("tb.forum_member_info");
        }
    }

    public byte[] JV(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> by = this.jbT != null ? this.jbT.by(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (by == null || by.value == null) {
            return null;
        }
        return by.value;
    }

    public void m(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            bes();
            this.jbT.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
