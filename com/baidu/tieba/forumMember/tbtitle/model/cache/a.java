package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> ccA;

    public a() {
        atM();
    }

    private void atM() {
        if (this.ccA == null) {
            this.ccA = com.baidu.tbadk.core.c.a.AR().dg("tb.tbtiel_level_info");
        }
    }

    public byte[] lw(String str) {
        l.b<byte[]> ae = (this.ccA == null || str == null) ? null : this.ccA.ae(str);
        if (ae == null || ae.value == null) {
            return null;
        }
        return ae.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            atM();
            this.ccA.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
