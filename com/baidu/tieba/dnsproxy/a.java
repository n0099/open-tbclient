package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes6.dex */
public class a {
    private static final String[] gKX = {"119.75.222.62", "119.75.222.63"};
    private static final String[] gKY = {"111.13.100.247", "117.185.16.61"};
    private static final String[] gKZ = {"111.206.37.190"};
    private static final String[] gLa = {"115.239.211.146", "180.97.33.196"};
    private volatile int cOA;
    private volatile String gKW;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bMT() {
        bMU();
        if (j.isWifiNet()) {
            return gLa[new Random().nextInt(gLa.length)];
        }
        if (j.isMobileNet()) {
            if (this.cOA == 1) {
                return gKX[new Random().nextInt(gKX.length)];
            }
            if (this.cOA == 2) {
                return gKY[new Random().nextInt(gKY.length)];
            }
            if (this.cOA == 3) {
                return gKZ[new Random().nextInt(gKZ.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bMU() {
        try {
            this.gKW = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.cOA = 0;
        if (this.gKW != null) {
            if (this.gKW.startsWith("46000") || this.gKW.startsWith("46002") || this.gKW.startsWith("46007")) {
                this.cOA = 1;
            } else if (this.gKW.startsWith("46001") || this.gKW.startsWith("46006")) {
                this.cOA = 2;
            } else if (this.gKW.startsWith("46003") || this.gKW.startsWith("46005")) {
                this.cOA = 3;
            }
        }
    }
}
