package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> bwp;

    public c() {
        asq();
    }

    public void asq() {
        if (this.bwp == null) {
            this.bwp = com.baidu.tbadk.core.c.a.xj().dA("tb.im_frsgroup");
        }
    }

    public byte[] S(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> an = this.bwp != null ? this.bwp.an("frs_group_" + i + "_" + str) : null;
        if (an == null || an.value == null) {
            return null;
        }
        return an.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            asq();
            this.bwp.a("frs_group_" + i + "_" + str, bArr, 604800000L);
        }
    }
}
