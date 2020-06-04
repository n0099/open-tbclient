package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes10.dex */
public class d {
    private l<byte[]> hjb;

    public d() {
        aHS();
    }

    public void aHS() {
        if (this.hjb == null) {
            this.hjb = com.baidu.tbadk.core.c.a.aSS().vL("tb.bawu_team_info");
        }
    }

    public byte[] Es(String str) {
        l.b<byte[]> bt = (this.hjb == null || str == null) ? null : this.hjb.bt(str);
        if (bt == null || bt.value == null) {
            return null;
        }
        return bt.value;
    }

    public void l(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aHS();
            this.hjb.set(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
