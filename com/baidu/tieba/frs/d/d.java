package com.baidu.tieba.frs.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.util.bd;
import java.util.Date;
/* loaded from: classes2.dex */
public class d {
    private String fid;
    private String uid;

    public d(String str, String str2) {
        this.uid = str;
        this.fid = str2;
    }

    private String cNd() {
        return this.uid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.fid;
    }

    public boolean cNe() {
        if (ei(this.uid, this.fid)) {
            String cNd = cNd();
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.bvr().getLong(cNd, 0L));
            long currentTimeMillis = System.currentTimeMillis();
            if (bd.b(new Date(currentTimeMillis), date) >= 2) {
                com.baidu.tbadk.core.sharedPref.b.bvr().putLong(cNd, currentTimeMillis);
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean ei(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }
}
