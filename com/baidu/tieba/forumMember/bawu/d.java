package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class d {
    private l<byte[]> buU;

    public d() {
        asf();
    }

    public void asf() {
        if (this.buU == null) {
            this.buU = com.baidu.tbadk.core.c.a.wW().dx("tb.bawu_team_info");
        }
    }

    public byte[] mi(String str) {
        l.b<byte[]> an = (this.buU == null || str == null) ? null : this.buU.an(str);
        if (an == null || an.value == null) {
            return null;
        }
        return an.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            asf();
            this.buU.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
