package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes22.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> iDA;

    public c() {
        bcw();
    }

    public void bcw() {
        if (this.iDA == null) {
            this.iDA = com.baidu.tbadk.core.c.a.bob().AG("tb.im_frsgroup");
        }
    }

    public byte[] bw(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bB = this.iDA != null ? this.iDA.bB("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            bcw();
            this.iDA.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
