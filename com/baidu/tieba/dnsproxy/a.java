package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes8.dex */
public class a {
    private static final String[] iEj = {"119.75.222.62", "119.75.222.63"};
    private static final String[] iEk = {"111.13.100.247", "117.185.16.61"};
    private static final String[] iEl = {"111.206.37.190"};
    private static final String[] iEm = {"115.239.211.146", "180.97.33.196"};
    private volatile int dVj;
    private volatile String iEi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String ctW() {
        ctX();
        if (j.isWifiNet()) {
            return iEm[new Random().nextInt(iEm.length)];
        }
        if (j.isMobileNet()) {
            if (this.dVj == 1) {
                return iEj[new Random().nextInt(iEj.length)];
            }
            if (this.dVj == 2) {
                return iEk[new Random().nextInt(iEk.length)];
            }
            if (this.dVj == 3) {
                return iEl[new Random().nextInt(iEl.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void ctX() {
        try {
            this.iEi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.dVj = 0;
        if (this.iEi != null) {
            if (this.iEi.startsWith("46000") || this.iEi.startsWith("46002") || this.iEi.startsWith("46007")) {
                this.dVj = 1;
            } else if (this.iEi.startsWith("46001") || this.iEi.startsWith("46006")) {
                this.dVj = 2;
            } else if (this.iEi.startsWith("46003") || this.iEi.startsWith("46005")) {
                this.dVj = 3;
            }
        }
    }
}
