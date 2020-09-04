package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes17.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> hOr;

    public c() {
        aVq();
    }

    public void aVq() {
        if (this.hOr == null) {
            this.hOr = com.baidu.tbadk.core.c.a.bhb().zx("tb.im_frsgroup");
        }
    }

    public byte[] bf(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bz = this.hOr != null ? this.hOr.bz("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (bz == null || bz.value == null) {
            return null;
        }
        return bz.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aVq();
            this.hOr.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
