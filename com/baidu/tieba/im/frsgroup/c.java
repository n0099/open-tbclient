package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> bmO;

    public c() {
        aoa();
    }

    public void aoa() {
        if (this.bmO == null) {
            this.bmO = com.baidu.tbadk.core.c.a.ty().cY("tb.im_frsgroup");
        }
    }

    public byte[] V(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ab = this.bmO != null ? this.bmO.ab("frs_group_" + i + "_" + str) : null;
        if (ab == null || ab.value == null) {
            return null;
        }
        return ab.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aoa();
            this.bmO.a("frs_group_" + i + "_" + str, bArr, 604800000L);
        }
    }
}
