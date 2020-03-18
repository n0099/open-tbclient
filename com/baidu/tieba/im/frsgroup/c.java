package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes10.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> gkR;

    public c() {
        ava();
    }

    public void ava() {
        if (this.gkR == null) {
            this.gkR = com.baidu.tbadk.core.c.a.aEF().sO("tb.im_frsgroup");
        }
    }

    public byte[] aI(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ad = this.gkR != null ? this.gkR.ad("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            ava();
            this.gkR.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
