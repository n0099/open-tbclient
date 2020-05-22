package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes10.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> hiQ;

    public c() {
        aHS();
    }

    public void aHS() {
        if (this.hiQ == null) {
            this.hiQ = com.baidu.tbadk.core.c.a.aSS().vL("tb.im_frsgroup");
        }
    }

    public byte[] bc(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bt = this.hiQ != null ? this.hiQ.bt("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (bt == null || bt.value == null) {
            return null;
        }
        return bt.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aHS();
            this.hiQ.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
