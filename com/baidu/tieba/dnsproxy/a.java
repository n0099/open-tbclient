package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes6.dex */
public class a {
    private static final String[] fQC = {"119.75.222.62", "119.75.222.63"};
    private static final String[] fQD = {"111.13.100.247", "117.185.16.61"};
    private static final String[] fQE = {"111.206.37.190"};
    private static final String[] fQF = {"115.239.211.146", "180.97.33.196"};
    private volatile int cdx;
    private volatile String fQB;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bwJ() {
        bwK();
        if (j.isWifiNet()) {
            return fQF[new Random().nextInt(fQF.length)];
        }
        if (j.isMobileNet()) {
            if (this.cdx == 1) {
                return fQC[new Random().nextInt(fQC.length)];
            }
            if (this.cdx == 2) {
                return fQD[new Random().nextInt(fQD.length)];
            }
            if (this.cdx == 3) {
                return fQE[new Random().nextInt(fQE.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bwK() {
        try {
            this.fQB = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.cdx = 0;
        if (this.fQB != null) {
            if (this.fQB.startsWith("46000") || this.fQB.startsWith("46002") || this.fQB.startsWith("46007")) {
                this.cdx = 1;
            } else if (this.fQB.startsWith("46001") || this.fQB.startsWith("46006")) {
                this.cdx = 2;
            } else if (this.fQB.startsWith("46003") || this.fQB.startsWith("46005")) {
                this.cdx = 3;
            }
        }
    }
}
