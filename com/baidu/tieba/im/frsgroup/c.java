package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> bwX;

    public c() {
        asT();
    }

    public void asT() {
        if (this.bwX == null) {
            this.bwX = com.baidu.tbadk.core.c.a.xa().dx("tb.im_frsgroup");
        }
    }

    public byte[] U(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ao = this.bwX != null ? this.bwX.ao("frs_group_" + i + "_" + str) : null;
        if (ao == null || ao.value == null) {
            return null;
        }
        return ao.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            asT();
            this.bwX.a("frs_group_" + i + "_" + str, bArr, 604800000L);
        }
    }
}
