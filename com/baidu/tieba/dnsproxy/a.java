package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes6.dex */
public class a {
    private static final String[] fQA = {"119.75.222.62", "119.75.222.63"};
    private static final String[] fQB = {"111.13.100.247", "117.185.16.61"};
    private static final String[] fQC = {"111.206.37.190"};
    private static final String[] fQD = {"115.239.211.146", "180.97.33.196"};
    private volatile int cdw;
    private volatile String fQz;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bwH() {
        bwI();
        if (j.isWifiNet()) {
            return fQD[new Random().nextInt(fQD.length)];
        }
        if (j.isMobileNet()) {
            if (this.cdw == 1) {
                return fQA[new Random().nextInt(fQA.length)];
            }
            if (this.cdw == 2) {
                return fQB[new Random().nextInt(fQB.length)];
            }
            if (this.cdw == 3) {
                return fQC[new Random().nextInt(fQC.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bwI() {
        try {
            this.fQz = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.cdw = 0;
        if (this.fQz != null) {
            if (this.fQz.startsWith("46000") || this.fQz.startsWith("46002") || this.fQz.startsWith("46007")) {
                this.cdw = 1;
            } else if (this.fQz.startsWith("46001") || this.fQz.startsWith("46006")) {
                this.cdw = 2;
            } else if (this.fQz.startsWith("46003") || this.fQz.startsWith("46005")) {
                this.cdw = 3;
            }
        }
    }
}
