package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class d {
    private l<byte[]> bmz;

    public d() {
        aob();
    }

    public void aob() {
        if (this.bmz == null) {
            this.bmz = com.baidu.tbadk.core.c.a.tz().cY("tb.bawu_team_info");
        }
    }

    public byte[] lz(String str) {
        l.b<byte[]> ab = (this.bmz == null || str == null) ? null : this.bmz.ab(str);
        if (ab == null || ab.value == null) {
            return null;
        }
        return ab.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aob();
            this.bmz.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
