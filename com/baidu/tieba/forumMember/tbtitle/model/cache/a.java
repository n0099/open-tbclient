package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes10.dex */
public class a {
    private l<byte[]> gkR;

    public a() {
        ava();
    }

    private void ava() {
        if (this.gkR == null) {
            this.gkR = com.baidu.tbadk.core.c.a.aEF().sO("tb.tbtiel_level_info");
        }
    }

    public byte[] AV(String str) {
        l.b<byte[]> ad = (this.gkR == null || str == null) ? null : this.gkR.ad(str);
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            ava();
            this.gkR.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
