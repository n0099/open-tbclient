package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes17.dex */
public class a {
    private l<byte[]> hAW;

    public a() {
        aMQ();
    }

    private void aMQ() {
        if (this.hAW == null) {
            this.hAW = com.baidu.tbadk.core.c.a.aYG().xi("tb.tbtiel_level_info");
        }
    }

    public byte[] FE(String str) {
        l.b<byte[]> bu = (this.hAW == null || str == null) ? null : this.hAW.bu(str);
        if (bu == null || bu.value == null) {
            return null;
        }
        return bu.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aMQ();
            this.hAW.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
