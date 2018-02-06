package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class d {
    private l<byte[]> ccJ;

    public d() {
        atM();
    }

    public void atM() {
        if (this.ccJ == null) {
            this.ccJ = com.baidu.tbadk.core.c.a.AQ().dg("tb.bawu_team_info");
        }
    }

    public byte[] lw(String str) {
        l.b<byte[]> ae = (this.ccJ == null || str == null) ? null : this.ccJ.ae(str);
        if (ae == null || ae.value == null) {
            return null;
        }
        return ae.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            atM();
            this.ccJ.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
