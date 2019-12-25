package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes7.dex */
public class d {
    private l<byte[]> geK;

    public d() {
        aso();
    }

    public void aso() {
        if (this.geK == null) {
            this.geK = com.baidu.tbadk.core.c.a.aBV().sw("tb.bawu_team_info");
        }
    }

    public byte[] At(String str) {
        l.b<byte[]> ad = (this.geK == null || str == null) ? null : this.geK.ad(str);
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aso();
            this.geK.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
