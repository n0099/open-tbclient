package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bQF;

    public a() {
        aAx();
    }

    private void aAx() {
        if (this.bQF == null) {
            this.bQF = com.baidu.tbadk.core.c.a.BO().eG("tb.tbtiel_level_info");
        }
    }

    public byte[] oh(String str) {
        l.b<byte[]> aF = (this.bQF == null || str == null) ? null : this.bQF.aF(str);
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aAx();
            this.bQF.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
