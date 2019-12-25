package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes7.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> geK;

    public c() {
        aso();
    }

    public void aso() {
        if (this.geK == null) {
            this.geK = com.baidu.tbadk.core.c.a.aBV().sw("tb.im_frsgroup");
        }
    }

    public byte[] aC(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ad = this.geK != null ? this.geK.ad("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aso();
            this.geK.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
