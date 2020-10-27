package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes23.dex */
public class c {
    private com.baidu.adp.lib.cache.l<byte[]> iwO;

    public c() {
        baD();
    }

    public void baD() {
        if (this.iwO == null) {
            this.iwO = com.baidu.tbadk.core.c.a.bmx().AX("tb.im_frsgroup");
        }
    }

    public byte[] bu(int i, String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        l.b<byte[]> bB = this.iwO != null ? this.iwO.bB("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str) : null;
        if (bB == null || bB.value == null) {
            return null;
        }
        return bB.value;
    }

    public void a(int i, String str, byte[] bArr) {
        if (!StringUtils.isNull(str)) {
            baD();
            this.iwO.set("frs_group_" + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str, bArr, 604800000L);
        }
    }
}
