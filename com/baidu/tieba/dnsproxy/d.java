package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes2.dex */
public class d {
    private static volatile d eSH = null;

    public static final d bei() {
        if (eSH == null) {
            synchronized (d.class) {
                if (eSH == null) {
                    eSH = new d();
                }
            }
        }
        return eSH;
    }

    private d() {
    }

    public void co(String str, String str2) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.append("workflow", "dnsproxy_error");
            if (!TextUtils.isEmpty(str)) {
                statsItem.append("reason", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                statsItem.append(ClientCookie.COMMENT_ATTR, str2);
            }
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }

    public void R(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.append("workflow", "dnsproxy_event");
            if (!TextUtils.isEmpty(str)) {
                statsItem.append("key", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                statsItem.append("reason", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                statsItem.append(ClientCookie.COMMENT_ATTR, str3);
            }
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }
}
