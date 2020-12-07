package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes23.dex */
public class d {
    private l<byte[]> iOs;

    public d() {
        bfB();
    }

    public void bfB() {
        if (this.iOs == null) {
            this.iOs = com.baidu.tbadk.core.c.a.brq().Bn("tb.bawu_team_info");
        }
    }

    public byte[] Kx(String str) {
        l.b<byte[]> bE = (this.iOs == null || str == null) ? null : this.iOs.bE(str);
        if (bE == null || bE.value == null) {
            return null;
        }
        return bE.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            bfB();
            this.iOs.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
