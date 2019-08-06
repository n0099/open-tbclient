package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes5.dex */
public class d {
    private l<byte[]> dsR;

    public d() {
        Xr();
    }

    public void Xr() {
        if (this.dsR == null) {
            this.dsR = com.baidu.tbadk.core.d.a.agH().mK("tb.bawu_team_info");
        }
    }

    public byte[] wJ(String str) {
        l.b<byte[]> aq = (this.dsR == null || str == null) ? null : this.dsR.aq(str);
        if (aq == null || aq.value == null) {
            return null;
        }
        return aq.value;
    }

    public void j(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            Xr();
            this.dsR.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
