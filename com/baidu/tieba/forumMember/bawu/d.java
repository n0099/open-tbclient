package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes5.dex */
public class d {
    private l<byte[]> fqn;

    public d() {
        aci();
    }

    public void aci() {
        if (this.fqn == null) {
            this.fqn = com.baidu.tbadk.core.d.a.akL().nk("tb.bawu_team_info");
        }
    }

    public byte[] vB(String str) {
        l.b<byte[]> Y = (this.fqn == null || str == null) ? null : this.fqn.Y(str);
        if (Y == null || Y.value == null) {
            return null;
        }
        return Y.value;
    }

    public void i(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aci();
            this.fqn.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
