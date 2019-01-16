package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> bQF;

    public c() {
        aAx();
    }

    public void aAx() {
        if (this.bQF == null) {
            this.bQF = com.baidu.tbadk.core.c.a.BO().eG("tb.im_frsgroup");
        }
    }

    public byte[] T(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> aF = this.bQF != null ? this.bQF.aF("frs_group_" + i + BaseRequestAction.SPLITE + str) : null;
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aAx();
            this.bQF.a("frs_group_" + i + BaseRequestAction.SPLITE + str, bArr, 604800000L);
        }
    }
}
