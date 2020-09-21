package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes22.dex */
public class d {
    private l<byte[]> hVr;

    public d() {
        aWc();
    }

    public void aWc() {
        if (this.hVr == null) {
            this.hVr = com.baidu.tbadk.core.c.a.bhV().zS("tb.bawu_team_info");
        }
    }

    public byte[] ID(String str) {
        l.b<byte[]> bB = (this.hVr == null || str == null) ? null : this.hVr.bB(str);
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aWc();
            this.hVr.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
