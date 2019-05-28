package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes5.dex */
public class a {
    private l<byte[]> dqB;

    public a() {
        Wx();
    }

    private void Wx() {
        if (this.dqB == null) {
            this.dqB = com.baidu.tbadk.core.c.a.afD().mA("tb.tbtiel_level_info");
        }
    }

    public byte[] we(String str) {
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
