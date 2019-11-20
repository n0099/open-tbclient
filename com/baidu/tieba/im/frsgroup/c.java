package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes5.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> fqn;

    public c() {
        aci();
    }

    public void aci() {
        if (this.fqn == null) {
            this.fqn = com.baidu.tbadk.core.d.a.akL().nk("tb.im_frsgroup");
        }
    }

    public byte[] an(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> Y = this.fqn != null ? this.fqn.Y("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (Y == null || Y.value == null) {
            return null;
        }
        return Y.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            aci();
            this.fqn.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
