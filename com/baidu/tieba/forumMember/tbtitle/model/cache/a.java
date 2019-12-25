package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes7.dex */
public class a {
    private l<byte[]> geK;

    public a() {
        aso();
    }

    private void aso() {
        if (this.geK == null) {
            this.geK = com.baidu.tbadk.core.c.a.aBV().sw("tb.tbtiel_level_info");
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
