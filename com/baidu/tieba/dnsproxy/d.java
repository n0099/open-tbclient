package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
/* loaded from: classes6.dex */
public class d {
    private static volatile d gYk = null;

    public static final d bQe() {
        if (gYk == null) {
            synchronized (d.class) {
                if (gYk == null) {
                    gYk = new d();
                }
            }
        }
        return gYk;
    }

    private d() {
    }

    public void dW(String str, String str2) {
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

    public void an(String str, String str2, String str3) {
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
