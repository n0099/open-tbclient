package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class d {
    private l<byte[]> ccA;

    public d() {
        atM();
    }

    public void atM() {
        if (this.ccA == null) {
            this.ccA = com.baidu.tbadk.core.c.a.AR().dg("tb.bawu_team_info");
        }
    }

    public byte[] lw(String str) {
        l.b<byte[]> ae = (this.ccA == null || str == null) ? null : this.ccA.ae(str);
        if (ae == null || ae.value == null) {
            return null;
        }
        return ae.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            atM();
            this.ccA.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
