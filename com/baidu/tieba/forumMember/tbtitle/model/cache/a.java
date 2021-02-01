package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes8.dex */
public class a {
    private l<byte[]> jbF;

    public a() {
        bes();
    }

    private void bes() {
        if (this.jbF == null) {
            this.jbF = com.baidu.tbadk.core.c.a.bqr().Ar("tb.tbtiel_level_info");
        }
    }

    public byte[] JU(String str) {
        l.b<byte[]> by = (this.jbF == null || str == null) ? null : this.jbF.by(str);
        if (by == null || by.value == null) {
            return null;
        }
        return by.value;
    }

    public void m(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            bes();
            this.jbF.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
