package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes13.dex */
public class a {
    private static final String[] iqT = {"119.75.222.62", "119.75.222.63"};
    private static final String[] iqU = {"111.13.100.247", "117.185.16.61"};
    private static final String[] iqV = {"111.206.37.190"};
    private static final String[] iqW = {"115.239.211.146", "180.97.33.196"};
    private volatile int dOX;
    private volatile String iqS;

    /* JADX INFO: Access modifiers changed from: protected */
    public String ctK() {
        ctL();
        if (j.isWifiNet()) {
            return iqW[new Random().nextInt(iqW.length)];
        }
        if (j.isMobileNet()) {
            if (this.dOX == 1) {
                return iqT[new Random().nextInt(iqT.length)];
            }
            if (this.dOX == 2) {
                return iqU[new Random().nextInt(iqU.length)];
            }
            if (this.dOX == 3) {
                return iqV[new Random().nextInt(iqV.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void ctL() {
        try {
            this.iqS = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.dOX = 0;
        if (this.iqS != null) {
            if (this.iqS.startsWith("46000") || this.iqS.startsWith("46002") || this.iqS.startsWith("46007")) {
                this.dOX = 1;
            } else if (this.iqS.startsWith("46001") || this.iqS.startsWith("46006")) {
                this.dOX = 2;
            } else if (this.iqS.startsWith("46003") || this.iqS.startsWith("46005")) {
                this.dOX = 3;
            }
        }
    }
}
