package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> buU;

    public c() {
        asf();
    }

    public void asf() {
        if (this.buU == null) {
            this.buU = com.baidu.tbadk.core.c.a.wW().dx("tb.im_frsgroup");
        }
    }

    public byte[] V(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> an = this.buU != null ? this.buU.an("frs_group_" + i + "_" + str) : null;
        if (an == null || an.value == null) {
            return null;
        }
        return an.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            asf();
            this.buU.a("frs_group_" + i + "_" + str, bArr, 604800000L);
        }
    }
}
