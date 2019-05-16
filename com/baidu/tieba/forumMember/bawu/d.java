package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes5.dex */
public class d {
    private l<byte[]> dqA;

    public d() {
        Wx();
    }

    public void Wx() {
        if (this.dqA == null) {
            this.dqA = com.baidu.tbadk.core.c.a.afD().mA("tb.bawu_team_info");
        }
    }

    public byte[] we(String str) {
        l.b<byte[]> ap = (this.dqA == null || str == null) ? null : this.dqA.ap(str);
        if (ap == null || ap.value == null) {
            return null;
        }
        return ap.value;
    }

    public void j(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            Wx();
            this.dqA.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
