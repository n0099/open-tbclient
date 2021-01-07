package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes8.dex */
public class a {
    private static final String[] iDg = {"119.75.222.62", "119.75.222.63"};
    private static final String[] iDh = {"111.13.100.247", "117.185.16.61"};
    private static final String[] iDi = {"111.206.37.190"};
    private static final String[] iDj = {"115.239.211.146", "180.97.33.196"};
    private volatile int dXP;
    private volatile String iDf;

    /* JADX INFO: Access modifiers changed from: protected */
    public String cwC() {
        cwD();
        if (j.isWifiNet()) {
            return iDj[new Random().nextInt(iDj.length)];
        }
        if (j.isMobileNet()) {
            if (this.dXP == 1) {
                return iDg[new Random().nextInt(iDg.length)];
            }
            if (this.dXP == 2) {
                return iDh[new Random().nextInt(iDh.length)];
            }
            if (this.dXP == 3) {
                return iDi[new Random().nextInt(iDi.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void cwD() {
        try {
            this.iDf = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.dXP = 0;
        if (this.iDf != null) {
            if (this.iDf.startsWith("46000") || this.iDf.startsWith("46002") || this.iDf.startsWith("46007")) {
                this.dXP = 1;
            } else if (this.iDf.startsWith("46001") || this.iDf.startsWith("46006")) {
                this.dXP = 2;
            } else if (this.iDf.startsWith("46003") || this.iDf.startsWith("46005")) {
                this.dXP = 3;
            }
        }
    }
}
