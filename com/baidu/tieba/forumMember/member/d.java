package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> bwX;

    public d() {
        asT();
    }

    public void asT() {
        if (this.bwX == null) {
            this.bwX = com.baidu.tbadk.core.c.a.xa().dx("tb.forum_member_info");
        }
    }

    public byte[] mj(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ao = this.bwX != null ? this.bwX.ao(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ao == null || ao.value == null) {
            return null;
        }
        return ao.value;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            asT();
            this.bwX.a(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
