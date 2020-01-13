package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes8.dex */
public class a {
    private l<byte[]> ghT;

    public a() {
        asH();
    }

    private void asH() {
        if (this.ghT == null) {
            this.ghT = com.baidu.tbadk.core.c.a.aCo().sz("tb.tbtiel_level_info");
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
