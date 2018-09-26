package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> bCM;

    public c() {
        auH();
    }

    public void auH() {
        if (this.bCM == null) {
            this.bCM = com.baidu.tbadk.core.c.a.yh().dP("tb.im_frsgroup");
        }
    }

    public byte[] U(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> aF = this.bCM != null ? this.bCM.aF("frs_group_" + i + "_" + str) : null;
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            auH();
            this.bCM.a("frs_group_" + i + "_" + str, bArr, 604800000L);
        }
    }
}
