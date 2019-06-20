package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes5.dex */
public class d {
    private l<byte[]> dqB;

    public d() {
        Wx();
    }

    public void Wx() {
        if (this.dqB == null) {
            this.dqB = com.baidu.tbadk.core.c.a.afD().mz("tb.bawu_team_info");
        }
    }

    public byte[] wd(String str) {
        l.b<byte[]> ap = (this.dqB == null || str == null) ? null : this.dqB.ap(str);
        if (ap == null || ap.value == null) {
            return null;
        }
        return ap.value;
    }

    public void j(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            Wx();
            this.dqB.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
