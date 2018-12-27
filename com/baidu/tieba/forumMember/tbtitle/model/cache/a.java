package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bPU;

    public a() {
        aAa();
    }

    private void aAa() {
        if (this.bPU == null) {
            this.bPU = com.baidu.tbadk.core.c.a.BB().ex("tb.tbtiel_level_info");
        }
    }

    public byte[] nQ(String str) {
        l.b<byte[]> aF = (this.bPU == null || str == null) ? null : this.bPU.aF(str);
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aAa();
            this.bPU.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
