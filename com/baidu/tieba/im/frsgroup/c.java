package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes10.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> gUe;

    public c() {
        aDl();
    }

    public void aDl() {
        if (this.gUe == null) {
            this.gUe = com.baidu.tbadk.core.c.a.aMR().uf("tb.im_frsgroup");
        }
    }

    public byte[] aX(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bs = this.gUe != null ? this.gUe.bs("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (bs == null || bs.value == null) {
            return null;
        }
        return bs.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aDl();
            this.gUe.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
