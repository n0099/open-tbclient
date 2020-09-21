package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes22.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> hVr;

    public c() {
        aWc();
    }

    public void aWc() {
        if (this.hVr == null) {
            this.hVr = com.baidu.tbadk.core.c.a.bhV().zS("tb.im_frsgroup");
        }
    }

    public byte[] bj(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bB = this.hVr != null ? this.hVr.bB("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aWc();
            this.hVr.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
