package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class d {
    private l<byte[]> bPU;

    public d() {
        aAa();
    }

    public void aAa() {
        if (this.bPU == null) {
            this.bPU = com.baidu.tbadk.core.c.a.BB().ex("tb.bawu_team_info");
        }
    }

    public byte[] nQ(String str) {
        l.b<byte[]> aF = (this.bPU == null || str == null) ? null : this.bPU.aF(str);
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aAa();
            this.bPU.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
