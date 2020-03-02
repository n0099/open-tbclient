package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes10.dex */
public class d {
    private l<byte[]> gjW;

    public d() {
        auX();
    }

    public void auX() {
        if (this.gjW == null) {
            this.gjW = com.baidu.tbadk.core.c.a.aEB().sP("tb.bawu_team_info");
        }
    }

    public byte[] AT(String str) {
        l.b<byte[]> ad = (this.gjW == null || str == null) ? null : this.gjW.ad(str);
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            auX();
            this.gjW.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
