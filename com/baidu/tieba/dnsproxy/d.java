package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
/* loaded from: classes6.dex */
public class d {
    private static volatile d gLc = null;

    public static final d bMW() {
        if (gLc == null) {
            synchronized (d.class) {
                if (gLc == null) {
                    gLc = new d();
                }
            }
        }
        return gLc;
    }

    private d() {
    }

    public void dR(String str, String str2) {
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

    public void am(String str, String str2, String str3) {
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
