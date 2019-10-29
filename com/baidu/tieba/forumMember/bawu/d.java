package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes5.dex */
public class d {
    private l<byte[]> fre;

    public d() {
        ack();
    }

    public void ack() {
        if (this.fre == null) {
            this.fre = com.baidu.tbadk.core.d.a.akN().nk("tb.bawu_team_info");
        }
    }

    public byte[] vB(String str) {
        l.b<byte[]> Y = (this.fre == null || str == null) ? null : this.fre.Y(str);
        if (Y == null || Y.value == null) {
            return null;
        }
        return Y.value;
    }

    public void i(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            ack();
            this.fre.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
