package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes13.dex */
public class a {
    private static final String[] hZh = {"119.75.222.62", "119.75.222.63"};
    private static final String[] hZi = {"111.13.100.247", "117.185.16.61"};
    private static final String[] hZj = {"111.206.37.190"};
    private static final String[] hZk = {"115.239.211.146", "180.97.33.196"};
    private volatile int dDP;
    private volatile String hZg;

    /* JADX INFO: Access modifiers changed from: protected */
    public String cnr() {
        cns();
        if (j.isWifiNet()) {
            return hZk[new Random().nextInt(hZk.length)];
        }
        if (j.isMobileNet()) {
            if (this.dDP == 1) {
                return hZh[new Random().nextInt(hZh.length)];
            }
            if (this.dDP == 2) {
                return hZi[new Random().nextInt(hZi.length)];
            }
            if (this.dDP == 3) {
                return hZj[new Random().nextInt(hZj.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void cns() {
        try {
            this.hZg = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.dDP = 0;
        if (this.hZg != null) {
            if (this.hZg.startsWith("46000") || this.hZg.startsWith("46002") || this.hZg.startsWith("46007")) {
                this.dDP = 1;
            } else if (this.hZg.startsWith("46001") || this.hZg.startsWith("46006")) {
                this.dDP = 2;
            } else if (this.hZg.startsWith("46003") || this.hZg.startsWith("46005")) {
                this.dDP = 3;
            }
        }
    }
}
