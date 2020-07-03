package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes10.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> hvk;

    public c() {
        aIY();
    }

    public void aIY() {
        if (this.hvk == null) {
            this.hvk = com.baidu.tbadk.core.c.a.aUM().wb("tb.im_frsgroup");
        }
    }

    public byte[] bg(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bu = this.hvk != null ? this.hvk.bu("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (bu == null || bu.value == null) {
            return null;
        }
        return bu.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aIY();
            this.hvk.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
