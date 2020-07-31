package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes17.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> hAW;

    public c() {
        aMQ();
    }

    public void aMQ() {
        if (this.hAW == null) {
            this.hAW = com.baidu.tbadk.core.c.a.aYG().xi("tb.im_frsgroup");
        }
    }

    public byte[] bi(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bu = this.hAW != null ? this.hAW.bu("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (bu == null || bu.value == null) {
            return null;
        }
        return bu.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aMQ();
            this.hAW.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
