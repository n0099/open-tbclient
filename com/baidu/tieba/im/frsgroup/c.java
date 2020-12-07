package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes23.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> iOs;

    public c() {
        bfB();
    }

    public void bfB() {
        if (this.iOs == null) {
            this.iOs = com.baidu.tbadk.core.c.a.brq().Bn("tb.im_frsgroup");
        }
    }

    public byte[] bw(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bE = this.iOs != null ? this.iOs.bE("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (bE == null || bE.value == null) {
            return null;
        }
        return bE.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            bfB();
            this.iOs.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
