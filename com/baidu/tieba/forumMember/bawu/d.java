package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes7.dex */
public class d {
    private l<byte[]> jdC;

    public d() {
        beu();
    }

    public void beu() {
        if (this.jdC == null) {
            this.jdC = com.baidu.tbadk.core.c.a.bqt().Ay("tb.bawu_team_info");
        }
    }

    public byte[] Ke(String str) {
        l.b<byte[]> bC = (this.jdC == null || str == null) ? null : this.jdC.bC(str);
        if (bC == null || bC.value == null) {
            return null;
        }
        return bC.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            beu();
            this.jdC.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
