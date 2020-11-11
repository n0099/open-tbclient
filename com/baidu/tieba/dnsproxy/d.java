package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
/* loaded from: classes13.dex */
public class d {
    private static volatile d ifn = null;

    public static final d cpV() {
        if (ifn == null) {
            synchronized (d.class) {
                if (ifn == null) {
                    ifn = new d();
                }
            }
        }
        return ifn;
    }

    private d() {
    }

    public void eG(String str, String str2) {
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

    public void ay(String str, String str2, String str3) {
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
