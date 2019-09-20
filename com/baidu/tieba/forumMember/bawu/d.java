package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes5.dex */
public class d {
    private l<byte[]> duC;

    public d() {
        Xv();
    }

    public void Xv() {
        if (this.duC == null) {
            this.duC = com.baidu.tbadk.core.d.a.agL().mM("tb.bawu_team_info");
        }
    }

    public byte[] xi(String str) {
        l.b<byte[]> aq = (this.duC == null || str == null) ? null : this.duC.aq(str);
        if (aq == null || aq.value == null) {
            return null;
        }
        return aq.value;
    }

    public void j(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            Xv();
            this.duC.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
