package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class d {
    private l<byte[]> bmO;

    public d() {
        aoa();
    }

    public void aoa() {
        if (this.bmO == null) {
            this.bmO = com.baidu.tbadk.core.c.a.ty().cY("tb.bawu_team_info");
        }
    }

    public byte[] lC(String str) {
        l.b<byte[]> ab = (this.bmO == null || str == null) ? null : this.bmO.ab(str);
        if (ab == null || ab.value == null) {
            return null;
        }
        return ab.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aoa();
            this.bmO.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
