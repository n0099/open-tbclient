package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes6.dex */
public class a {
    private volatile int cdJ;
    private volatile String fRx;
    private static final String[] fRy = {"119.75.222.62", "119.75.222.63"};
    private static final String[] fRz = {"111.13.100.247", "117.185.16.61"};
    private static final String[] fRA = {"111.206.37.190"};
    private static final String[] fRB = {"115.239.211.146", "180.97.33.196"};

    /* JADX INFO: Access modifiers changed from: protected */
    public String bwP() {
        bwQ();
        if (j.isWifiNet()) {
            return fRB[new Random().nextInt(fRB.length)];
        }
        if (j.isMobileNet()) {
            if (this.cdJ == 1) {
                return fRy[new Random().nextInt(fRy.length)];
            }
            if (this.cdJ == 2) {
                return fRz[new Random().nextInt(fRz.length)];
            }
            if (this.cdJ == 3) {
                return fRA[new Random().nextInt(fRA.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bwQ() {
        try {
            this.fRx = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.cdJ = 0;
        if (this.fRx != null) {
            if (this.fRx.startsWith("46000") || this.fRx.startsWith("46002") || this.fRx.startsWith("46007")) {
                this.cdJ = 1;
            } else if (this.fRx.startsWith("46001") || this.fRx.startsWith("46006")) {
                this.cdJ = 2;
            } else if (this.fRx.startsWith("46003") || this.fRx.startsWith("46005")) {
                this.cdJ = 3;
            }
        }
    }
}
