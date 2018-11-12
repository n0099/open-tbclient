package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class d {
    private l<byte[]> bMc;

    public d() {
        axB();
    }

    public void axB() {
        if (this.bMc == null) {
            this.bMc = com.baidu.tbadk.core.c.a.Ax().ef("tb.bawu_team_info");
        }
    }

    public byte[] no(String str) {
        l.b<byte[]> aF = (this.bMc == null || str == null) ? null : this.bMc.aF(str);
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            axB();
            this.bMc.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
