package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes8.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> jaF;

    public c() {
        bhZ();
    }

    public void bhZ() {
        if (this.jaF == null) {
            this.jaF = com.baidu.tbadk.core.c.a.btT().Bl("tb.forum_member_info");
        }
    }

    public byte[] Ku(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> by = this.jaF != null ? this.jaF.by(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (by == null || by.value == null) {
            return null;
        }
        return by.value;
    }

    public void m(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            bhZ();
            this.jaF.set(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
