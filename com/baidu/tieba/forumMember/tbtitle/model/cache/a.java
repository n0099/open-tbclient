package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {
    private l<byte[]> bwV;

    public a() {
        asU();
    }

    private void asU() {
        if (this.bwV == null) {
            this.bwV = com.baidu.tbadk.core.c.a.xb().dx("tb.tbtiel_level_info");
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
