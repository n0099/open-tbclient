package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> duC;

    public c() {
        Xv();
    }

    public void Xv() {
        if (this.duC == null) {
            this.duC = com.baidu.tbadk.core.d.a.agL().mM("tb.im_frsgroup");
        }
    }

    public byte[] ao(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> aq = this.duC != null ? this.duC.aq("frs_group_" + i + "_" + str) : null;
        if (aq == null || aq.value == null) {
            return null;
        }
        return aq.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            Xv();
            this.duC.a("frs_group_" + i + "_" + str, bArr, 604800000L);
        }
    }
}
