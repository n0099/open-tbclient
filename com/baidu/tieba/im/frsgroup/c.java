package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes10.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> gTY;

    public c() {
        aDl();
    }

    public void aDl() {
        if (this.gTY == null) {
            this.gTY = com.baidu.tbadk.core.c.a.aMT().uc("tb.im_frsgroup");
        }
    }

    public byte[] aX(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bs = this.gTY != null ? this.gTY.bs("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (bs == null || bs.value == null) {
            return null;
        }
        return bs.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aDl();
            this.gTY.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
