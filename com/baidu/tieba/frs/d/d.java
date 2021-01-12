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

    private String cJl() {
        return this.uid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.fid;
    }

    public boolean cJm() {
        if (eh(this.uid, this.fid)) {
            String cJl = cJl();
            Date date = new Date(com.baidu.tbadk.core.sharedPref.b.brx().getLong(cJl, 0L));
            long currentTimeMillis = System.currentTimeMillis();
            if (bd.b(new Date(currentTimeMillis), date) >= 2) {
                com.baidu.tbadk.core.sharedPref.b.brx().putLong(cJl, currentTimeMillis);
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean eh(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }
}
