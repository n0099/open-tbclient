package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> hvk;

    public d() {
        aIY();
    }

    public void aIY() {
        if (this.hvk == null) {
            this.hvk = com.baidu.tbadk.core.c.a.aUM().wb("tb.forum_member_info");
        }
    }

    public byte[] ET(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bu = this.hvk != null ? this.hvk.bu(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (bu == null || bu.value == null) {
            return null;
        }
        return bu.value;
    }

    public void l(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            aIY();
            this.hvk.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
