package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes5.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> fre;

    public c() {
        ack();
    }

    public void ack() {
        if (this.fre == null) {
            this.fre = com.baidu.tbadk.core.d.a.akN().nk("tb.im_frsgroup");
        }
    }

    public byte[] ao(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> Y = this.fre != null ? this.fre.Y("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (Y == null || Y.value == null) {
            return null;
        }
        return Y.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            ack();
            this.fre.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
