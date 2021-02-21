package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes8.dex */
public class d {
    private l<byte[]> jbT;

    public d() {
        bes();
    }

    public void bes() {
        if (this.jbT == null) {
            this.jbT = com.baidu.tbadk.core.c.a.bqr().Ar("tb.bawu_team_info");
        }
    }

    public byte[] JV(String str) {
        l.b<byte[]> by = (this.jbT == null || str == null) ? null : this.jbT.by(str);
        if (by == null || by.value == null) {
            return null;
        }
        return by.value;
    }

    public void m(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            bes();
            this.jbT.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
