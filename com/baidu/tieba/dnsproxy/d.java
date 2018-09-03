package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.fsg.base.armor.RimArmor;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes3.dex */
public class d {
    private static volatile d cOX = null;

    public static final d any() {
        if (cOX == null) {
            synchronized (d.class) {
                if (cOX == null) {
                    cOX = new d();
                }
            }
        }
        return cOX;
    }

    private d() {
    }

    public void aQ(String str, String str2) {
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

    public void y(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.append("workflow", "dnsproxy_event");
            if (!TextUtils.isEmpty(str)) {
                statsItem.append(RimArmor.KEY, str);
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
