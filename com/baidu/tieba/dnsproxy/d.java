package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
/* loaded from: classes8.dex */
public class d {
    private static volatile d iEC = null;

    public static final d cug() {
        if (iEC == null) {
            synchronized (d.class) {
                if (iEC == null) {
                    iEC = new d();
                }
            }
        }
        return iEC;
    }

    private d() {
    }

    public void error(String str, String str2) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.append("workflow", "dnsproxy_error");
            if (!TextUtils.isEmpty(str)) {
                statsItem.append(TiebaInitialize.LogFields.REASON, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                statsItem.append("comment", str2);
            }
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }

    public void aD(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.append("workflow", "dnsproxy_event");
            if (!TextUtils.isEmpty(str)) {
                statsItem.append("key", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                statsItem.append(TiebaInitialize.LogFields.REASON, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                statsItem.append("comment", str3);
            }
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }
}
