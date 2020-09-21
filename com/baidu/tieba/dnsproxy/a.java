package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes13.dex */
public class a {
    private static final String[] hxP = {"119.75.222.62", "119.75.222.63"};
    private static final String[] hxQ = {"111.13.100.247", "117.185.16.61"};
    private static final String[] hxR = {"111.206.37.190"};
    private static final String[] hxS = {"115.239.211.146", "180.97.33.196"};
    private volatile int djm;
    private volatile String hxO;

    /* JADX INFO: Access modifiers changed from: protected */
    public String cgO() {
        cgP();
        if (j.isWifiNet()) {
            return hxS[new Random().nextInt(hxS.length)];
        }
        if (j.isMobileNet()) {
            if (this.djm == 1) {
                return hxP[new Random().nextInt(hxP.length)];
            }
            if (this.djm == 2) {
                return hxQ[new Random().nextInt(hxQ.length)];
            }
            if (this.djm == 3) {
                return hxR[new Random().nextInt(hxR.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void cgP() {
        try {
            this.hxO = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.djm = 0;
        if (this.hxO != null) {
            if (this.hxO.startsWith("46000") || this.hxO.startsWith("46002") || this.hxO.startsWith("46007")) {
                this.djm = 1;
            } else if (this.hxO.startsWith("46001") || this.hxO.startsWith("46006")) {
                this.djm = 2;
            } else if (this.hxO.startsWith("46003") || this.hxO.startsWith("46005")) {
                this.djm = 3;
            }
        }
    }
}
