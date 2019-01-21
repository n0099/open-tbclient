package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
/* loaded from: classes3.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> bQG;

    public c() {
        aAx();
    }

    public void aAx() {
        if (this.bQG == null) {
            this.bQG = com.baidu.tbadk.core.c.a.BO().eG("tb.im_frsgroup");
        }
    }

    public byte[] T(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> aF = this.bQG != null ? this.bQG.aF("frs_group_" + i + BaseRequestAction.SPLITE + str) : null;
        if (aF == null || aF.value == null) {
            return null;
        }
        return aF.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aAx();
            this.bQG.a("frs_group_" + i + BaseRequestAction.SPLITE + str, bArr, 604800000L);
        }
    }
}
