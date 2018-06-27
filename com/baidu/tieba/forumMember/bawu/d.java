package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class d {
    private l<byte[]> bwp;

    public d() {
        asq();
    }

    public void asq() {
        if (this.bwp == null) {
            this.bwp = com.baidu.tbadk.core.c.a.xj().dA("tb.bawu_team_info");
        }
    }

    public byte[] mi(String str) {
        l.b<byte[]> an = (this.bwp == null || str == null) ? null : this.bwp.an(str);
        if (an == null || an.value == null) {
            return null;
        }
        return an.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            asq();
            this.bwp.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
