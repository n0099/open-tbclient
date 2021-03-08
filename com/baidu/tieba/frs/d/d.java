package com.baidu.tieba.frs.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.util.be;
import java.util.Date;
/* loaded from: classes2.dex */
public class d {
    private String fid;
    private String uid;

    public d(String str, String str2) {
        this.uid = str;
        this.fid = str2;
    }

    private String cKL() {
        return this.uid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.fid;
    }

    public boolean cKM() {
        if (ee(this.uid, this.fid)) {
            String cKL = cKL();
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.brR().getLong(cKL, 0L));
            long currentTimeMillis = System.currentTimeMillis();
            if (be.b(new Date(currentTimeMillis), date) >= 2) {
                com.baidu.tbadk.core.sharedPref.b.brR().putLong(cKL, currentTimeMillis);
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean ee(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }
}
