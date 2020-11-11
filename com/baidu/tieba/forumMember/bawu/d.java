package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes23.dex */
public class d {
    private l<byte[]> iCL;

    public d() {
        bdd();
    }

    public void bdd() {
        if (this.iCL == null) {
            this.iCL = com.baidu.tbadk.core.c.a.boX().Bl("tb.bawu_team_info");
        }
    }

    public byte[] Kg(String str) {
        l.b<byte[]> bB = (this.iCL == null || str == null) ? null : this.iCL.bB(str);
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            bdd();
            this.iCL.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
