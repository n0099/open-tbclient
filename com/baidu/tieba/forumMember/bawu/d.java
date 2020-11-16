package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes22.dex */
public class d {
    private l<byte[]> iDA;

    public d() {
        bcw();
    }

    public void bcw() {
        if (this.iDA == null) {
            this.iDA = com.baidu.tbadk.core.c.a.bob().AG("tb.bawu_team_info");
        }
    }

    public byte[] JH(String str) {
        l.b<byte[]> bB = (this.iDA == null || str == null) ? null : this.iDA.bB(str);
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            bcw();
            this.iDA.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
