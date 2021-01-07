package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes8.dex */
public class d {
    private l<byte[]> jaF;

    public d() {
        bhZ();
    }

    public void bhZ() {
        if (this.jaF == null) {
            this.jaF = com.baidu.tbadk.core.c.a.btT().Bl("tb.bawu_team_info");
        }
    }

    public byte[] Ku(String str) {
        l.b<byte[]> by = (this.jaF == null || str == null) ? null : this.jaF.by(str);
        if (by == null || by.value == null) {
            return null;
        }
        return by.value;
    }

    public void m(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            bhZ();
            this.jaF.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
