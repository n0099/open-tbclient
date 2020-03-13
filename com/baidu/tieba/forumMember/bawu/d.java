package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes10.dex */
public class d {
    private l<byte[]> gkj;

    public d() {
        auX();
    }

    public void auX() {
        if (this.gkj == null) {
            this.gkj = com.baidu.tbadk.core.c.a.aEB().sP("tb.bawu_team_info");
        }
    }

    public byte[] AU(String str) {
        l.b<byte[]> ad = (this.gkj == null || str == null) ? null : this.gkj.ad(str);
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            auX();
            this.gkj.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
