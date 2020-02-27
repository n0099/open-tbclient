package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes10.dex */
public class a {
    private l<byte[]> gjU;

    public a() {
        auV();
    }

    private void auV() {
        if (this.gjU == null) {
            this.gjU = com.baidu.tbadk.core.c.a.aEz().sP("tb.tbtiel_level_info");
        }
    }

    public byte[] AT(String str) {
        l.b<byte[]> ad = (this.gjU == null || str == null) ? null : this.gjU.ad(str);
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            auV();
            this.gjU.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
