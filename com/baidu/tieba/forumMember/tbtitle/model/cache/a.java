package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> buU;

    public a() {
        asf();
    }

    private void asf() {
        if (this.buU == null) {
            this.buU = com.baidu.tbadk.core.c.a.wW().dx("tb.tbtiel_level_info");
        }
    }

    public byte[] mi(String str) {
        l.b<byte[]> an = (this.buU == null || str == null) ? null : this.buU.an(str);
        if (an == null || an.value == null) {
            return null;
        }
        return an.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            asf();
            this.buU.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
