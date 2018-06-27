package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bwp;

    public a() {
        asq();
    }

    private void asq() {
        if (this.bwp == null) {
            this.bwp = com.baidu.tbadk.core.c.a.xj().dA("tb.tbtiel_level_info");
        }
    }

    public byte[] mi(String str) {
        l.b<byte[]> an = (this.bwp == null || str == null) ? null : this.bwp.an(str);
        if (an == null || an.value == null) {
            return null;
        }
        return an.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            asq();
            this.bwp.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
