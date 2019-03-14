package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> dfT;

    public c() {
        SM();
    }

    public void SM() {
        if (this.dfT == null) {
            this.dfT = com.baidu.tbadk.core.c.a.aaW().lu("tb.im_frsgroup");
        }
    }

    public byte[] aj(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> aF = this.dfT != null ? this.dfT.aF("frs_group_" + i + "_" + str) : null;
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            SM();
            this.dfT.a("frs_group_" + i + "_" + str, bArr, 604800000L);
        }
    }
}
