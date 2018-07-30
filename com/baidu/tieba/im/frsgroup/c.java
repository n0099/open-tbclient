package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> bwV;

    public c() {
        asU();
    }

    public void asU() {
        if (this.bwV == null) {
            this.bwV = com.baidu.tbadk.core.c.a.xb().dx("tb.im_frsgroup");
        }
    }

    public byte[] U(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ao = this.bwV != null ? this.bwV.ao("frs_group_" + i + "_" + str) : null;
        if (ao == null || ao.value == null) {
            return null;
        }
        return ao.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            asU();
            this.bwV.a("frs_group_" + i + "_" + str, bArr, 604800000L);
        }
    }
}
