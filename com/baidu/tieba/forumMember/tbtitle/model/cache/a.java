package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bLr;

    public a() {
        aye();
    }

    private void aye() {
        if (this.bLr == null) {
            this.bLr = com.baidu.tbadk.core.c.a.Aq().ef("tb.tbtiel_level_info");
        }
    }

    public byte[] nn(String str) {
        l.b<byte[]> aF = (this.bLr == null || str == null) ? null : this.bLr.aF(str);
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aye();
            this.bLr.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
