package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> dqB;

    public c() {
        Wx();
    }

    public void Wx() {
        if (this.dqB == null) {
            this.dqB = com.baidu.tbadk.core.c.a.afD().mA("tb.im_frsgroup");
        }
    }

    public byte[] ao(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ap = this.dqB != null ? this.dqB.ap("frs_group_" + i + "_" + str) : null;
        if (ap == null || ap.value == null) {
            return null;
        }
        return ap.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            Wx();
            this.dqB.a("frs_group_" + i + "_" + str, bArr, 604800000L);
        }
    }
}
