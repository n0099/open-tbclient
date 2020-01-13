package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes8.dex */
public class d {
    private l<byte[]> ghT;

    public d() {
        asH();
    }

    public void asH() {
        if (this.ghT == null) {
            this.ghT = com.baidu.tbadk.core.c.a.aCo().sz("tb.bawu_team_info");
        }
    }

    public byte[] AD(String str) {
        l.b<byte[]> ad = (this.ghT == null || str == null) ? null : this.ghT.ad(str);
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            asH();
            this.ghT.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
