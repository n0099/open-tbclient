package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class d {
    private l<byte[]> ccx;

    public d() {
        atL();
    }

    public void atL() {
        if (this.ccx == null) {
            this.ccx = com.baidu.tbadk.core.c.a.AQ().dg("tb.bawu_team_info");
        }
    }

    public byte[] lw(String str) {
        l.b<byte[]> ae = (this.ccx == null || str == null) ? null : this.ccx.ae(str);
        if (ae == null || ae.value == null) {
            return null;
        }
        return ae.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            atL();
            this.ccx.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
