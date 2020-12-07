package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes13.dex */
public class a {
    private static final String[] iqR = {"119.75.222.62", "119.75.222.63"};
    private static final String[] iqS = {"111.13.100.247", "117.185.16.61"};
    private static final String[] iqT = {"111.206.37.190"};
    private static final String[] iqU = {"115.239.211.146", "180.97.33.196"};
    private volatile int dOX;
    private volatile String iqQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public String ctJ() {
        ctK();
        if (j.isWifiNet()) {
            return iqU[new Random().nextInt(iqU.length)];
        }
        if (j.isMobileNet()) {
            if (this.dOX == 1) {
                return iqR[new Random().nextInt(iqR.length)];
            }
            if (this.dOX == 2) {
                return iqS[new Random().nextInt(iqS.length)];
            }
            if (this.dOX == 3) {
                return iqT[new Random().nextInt(iqT.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void ctK() {
        try {
            this.iqQ = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.dOX = 0;
        if (this.iqQ != null) {
            if (this.iqQ.startsWith("46000") || this.iqQ.startsWith("46002") || this.iqQ.startsWith("46007")) {
                this.dOX = 1;
            } else if (this.iqQ.startsWith("46001") || this.iqQ.startsWith("46006")) {
                this.dOX = 2;
            } else if (this.iqQ.startsWith("46003") || this.iqQ.startsWith("46005")) {
                this.dOX = 3;
            }
        }
    }
}
