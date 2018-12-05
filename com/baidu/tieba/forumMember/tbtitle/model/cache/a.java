package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bPR;

    public a() {
        azl();
    }

    private void azl() {
        if (this.bPR == null) {
            this.bPR = com.baidu.tbadk.core.c.a.BB().ex("tb.tbtiel_level_info");
        }
    }

    public byte[] nN(String str) {
        l.b<byte[]> aF = (this.bPR == null || str == null) ? null : this.bPR.aF(str);
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            azl();
            this.bPR.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
