package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes6.dex */
public class a {
    private static final String[] fQP = {"119.75.222.62", "119.75.222.63"};
    private static final String[] fQQ = {"111.13.100.247", "117.185.16.61"};
    private static final String[] fQR = {"111.206.37.190"};
    private static final String[] fQS = {"115.239.211.146", "180.97.33.196"};
    private volatile int cdy;
    private volatile String fQO;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bwK() {
        bwL();
        if (j.isWifiNet()) {
            return fQS[new Random().nextInt(fQS.length)];
        }
        if (j.isMobileNet()) {
            if (this.cdy == 1) {
                return fQP[new Random().nextInt(fQP.length)];
            }
            if (this.cdy == 2) {
                return fQQ[new Random().nextInt(fQQ.length)];
            }
            if (this.cdy == 3) {
                return fQR[new Random().nextInt(fQR.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bwL() {
        try {
            this.fQO = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.cdy = 0;
        if (this.fQO != null) {
            if (this.fQO.startsWith("46000") || this.fQO.startsWith("46002") || this.fQO.startsWith("46007")) {
                this.cdy = 1;
            } else if (this.fQO.startsWith("46001") || this.fQO.startsWith("46006")) {
                this.cdy = 2;
            } else if (this.fQO.startsWith("46003") || this.fQO.startsWith("46005")) {
                this.cdy = 3;
            }
        }
    }
}
