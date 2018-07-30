package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class d {
    private l<byte[]> bwV;

    public d() {
        asU();
    }

    public void asU() {
        if (this.bwV == null) {
            this.bwV = com.baidu.tbadk.core.c.a.xb().dx("tb.bawu_team_info");
        }
    }

    public byte[] mh(String str) {
        l.b<byte[]> ao = (this.bwV == null || str == null) ? null : this.bwV.ao(str);
        if (ao == null || ao.value == null) {
            return null;
        }
        return ao.value;
    }

    public void k(String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            asU();
            this.bwV.a(str, bArr, TbConfig.MILLS_7DAYS);
        }
    }
}
