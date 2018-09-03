package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class d {
    private l<byte[]> bwX;

    public d() {
        asT();
    }

    public void asT() {
        if (this.bwX == null) {
            this.bwX = com.baidu.tbadk.core.c.a.xa().dx("tb.bawu_team_info");
        }
    }

    public byte[] mj(String str) {
        l.b<byte[]> ao = (this.bwX == null || str == null) ? null : this.bwX.ao(str);
        if (ao == null || ao.value == null) {
            return null;
        }
        return ao.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            asT();
            this.bwX.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
