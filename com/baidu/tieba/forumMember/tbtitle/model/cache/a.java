package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes7.dex */
public class a {
    private l<byte[]> iVY;

    public a() {
        bef();
    }

    private void bef() {
        if (this.iVY == null) {
            this.iVY = com.baidu.tbadk.core.c.a.bpZ().Aa("tb.tbtiel_level_info");
        }
    }

    public byte[] Jj(String str) {
        l.b<byte[]> by = (this.iVY == null || str == null) ? null : this.iVY.by(str);
        if (by == null || by.value == null) {
            return null;
        }
        return by.value;
    }

    public void m(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            bef();
            this.iVY.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
