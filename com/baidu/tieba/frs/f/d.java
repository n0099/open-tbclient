package com.baidu.tieba.frs.f;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.util.be;
import java.util.Date;
/* loaded from: classes22.dex */
public class d {
    private String fid;
    private String uid;

    public d(String str, String str2) {
        this.uid = str;
        this.fid = str2;
    }

    private String cKa() {
        return this.uid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.fid;
    }

    public boolean cKb() {
        if (ej(this.uid, this.fid)) {
            String cKa = cKa();
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.bsO().getLong(cKa, 0L));
            long currentTimeMillis = System.currentTimeMillis();
            if (be.b(new Date(currentTimeMillis), date) >= 2) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putLong(cKa, currentTimeMillis);
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean ej(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }
}
