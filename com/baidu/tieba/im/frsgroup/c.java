package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> dsK;

    public c() {
        Xr();
    }

    public void Xr() {
        if (this.dsK == null) {
            this.dsK = com.baidu.tbadk.core.d.a.agF().mK("tb.im_frsgroup");
        }
    }

    public byte[] ao(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> aq = this.dsK != null ? this.dsK.aq("frs_group_" + i + "_" + str) : null;
        if (aq == null || aq.value == null) {
            return null;
        }
        return aq.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            Xr();
            this.dsK.a("frs_group_" + i + "_" + str, bArr, 604800000L);
        }
    }
}
