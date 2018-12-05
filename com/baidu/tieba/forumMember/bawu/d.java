package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class d {
    private l<byte[]> bPR;

    public d() {
        azl();
    }

    public void azl() {
        if (this.bPR == null) {
            this.bPR = com.baidu.tbadk.core.c.a.BB().ex("tb.bawu_team_info");
        }
    }

    public byte[] nN(String str) {
        l.b<byte[]> aF = (this.bPR == null || str == null) ? null : this.bPR.aF(str);
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            azl();
            this.bPR.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
