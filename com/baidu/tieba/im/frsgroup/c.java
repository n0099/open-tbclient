package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> ccJ;

    public c() {
        atM();
    }

    public void atM() {
        if (this.ccJ == null) {
            this.ccJ = com.baidu.tbadk.core.c.a.AQ().dg("tb.im_frsgroup");
        }
    }

    public byte[] M(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ae = this.ccJ != null ? this.ccJ.ae("frs_group_" + i + "_" + str) : null;
        if (ae == null || ae.value == null) {
            return null;
        }
        return ae.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            atM();
            this.ccJ.a("frs_group_" + i + "_" + str, bArr, 604800000L);
        }
    }
}
