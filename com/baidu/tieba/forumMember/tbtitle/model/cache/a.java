package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes23.dex */
public class a {
    private l<byte[]> ikq;

    public a() {
        aYK();
    }

    private void aYK() {
        if (this.ikq == null) {
            this.ikq = com.baidu.tbadk.core.c.a.bkE().AE("tb.tbtiel_level_info");
        }
    }

    public byte[] Jq(String str) {
        l.b<byte[]> bB = (this.ikq == null || str == null) ? null : this.ikq.bB(str);
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aYK();
            this.ikq.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
