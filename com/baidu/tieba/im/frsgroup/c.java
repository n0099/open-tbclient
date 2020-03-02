package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes10.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> gjW;

    public c() {
        auX();
    }

    public void auX() {
        if (this.gjW == null) {
            this.gjW = com.baidu.tbadk.core.c.a.aEB().sP("tb.im_frsgroup");
        }
    }

    public byte[] aI(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ad = this.gjW != null ? this.gjW.ad("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            auX();
            this.gjW.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
