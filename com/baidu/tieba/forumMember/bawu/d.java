package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes10.dex */
public class d {
    private l<byte[]> gTY;

    public d() {
        aDl();
    }

    public void aDl() {
        if (this.gTY == null) {
            this.gTY = com.baidu.tbadk.core.c.a.aMT().uc("tb.bawu_team_info");
        }
    }

    public byte[] CG(String str) {
        l.b<byte[]> bs = (this.gTY == null || str == null) ? null : this.gTY.bs(str);
        if (bs == null || bs.value == null) {
            return null;
        }
        return bs.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aDl();
            this.gTY.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
