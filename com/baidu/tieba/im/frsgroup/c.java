package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes5.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> dfX;

    public c() {
        SK();
    }

    public void SK() {
        if (this.dfX == null) {
            this.dfX = com.baidu.tbadk.core.c.a.aaT().lv("tb.im_frsgroup");
        }
    }

    public byte[] al(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> aF = this.dfX != null ? this.dfX.aF("frs_group_" + i + "_" + str) : null;
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            SK();
            this.dfX.a("frs_group_" + i + "_" + str, bArr, 604800000L);
        }
    }
}
