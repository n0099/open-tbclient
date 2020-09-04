package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes17.dex */
public class a {
    private l<byte[]> hOr;

    public a() {
        aVq();
    }

    private void aVq() {
        if (this.hOr == null) {
            this.hOr = com.baidu.tbadk.core.c.a.bhb().zx("tb.tbtiel_level_info");
        }
    }

    public byte[] Ig(String str) {
        l.b<byte[]> bz = (this.hOr == null || str == null) ? null : this.hOr.bz(str);
        if (bz == null || bz.value == null) {
            return null;
        }
        return bz.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aVq();
            this.hOr.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
