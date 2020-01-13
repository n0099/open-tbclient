package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes8.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> ghT;

    public c() {
        asH();
    }

    public void asH() {
        if (this.ghT == null) {
            this.ghT = com.baidu.tbadk.core.c.a.aCo().sz("tb.im_frsgroup");
        }
    }

    public byte[] aI(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> ad = this.ghT != null ? this.ghT.ad("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (ad == null || ad.value == null) {
            return null;
        }
        return ad.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            asH();
            this.ghT.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
