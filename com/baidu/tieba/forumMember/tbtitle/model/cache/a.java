package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes7.dex */
public class a {
    private l<byte[]> jdC;

    public a() {
        beu();
    }

    private void beu() {
        if (this.jdC == null) {
            this.jdC = com.baidu.tbadk.core.c.a.bqt().Ay("tb.tbtiel_level_info");
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
