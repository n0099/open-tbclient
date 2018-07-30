package com.baidu.tieba.forumMember.member;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class d {
    private com.baidu.adp.lib.cache.l<byte[]> bwV;

    public d() {
        asU();
    }

    public void asU() {
        if (this.bwV == null) {
            this.bwV = com.baidu.tbadk.core.c.a.xb().dx("tb.forum_member_info");
        }
    }

    public byte[] mh(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ao = this.bwV != null ? this.bwV.ao(str + "/" + TbadkCoreApplication.getCurrentAccount()) : null;
        if (ao == null || ao.value == null) {
            return null;
        }
        return ao.value;
    }

    public void k(String str, byte[] bArr) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(str)) {
            asU();
            this.bwV.a(str + "/" + currentAccount, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
