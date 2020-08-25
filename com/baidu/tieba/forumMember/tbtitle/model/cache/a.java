package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes17.dex */
public class a {
    private l<byte[]> hOl;

    public a() {
        aVq();
    }

    private void aVq() {
        if (this.hOl == null) {
            this.hOl = com.baidu.tbadk.core.c.a.bhb().zw("tb.tbtiel_level_info");
        }
    }

    public byte[] If(String str) {
        l.b<byte[]> bz = (this.hOl == null || str == null) ? null : this.hOl.bz(str);
        if (bz == null || bz.value == null) {
            return null;
        }
        return bz.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aVq();
            this.hOl.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
