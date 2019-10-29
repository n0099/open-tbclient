package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes2.dex */
public class a {
    private static final String[] eXe = {"119.75.222.62", "119.75.222.63"};
    private static final String[] eXf = {"111.13.100.247", "117.185.16.61"};
    private static final String[] eXg = {"111.206.37.190"};
    private static final String[] eXh = {"115.239.211.146", "180.97.33.196"};
    private volatile int eXc;
    private volatile String eXd;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bcG() {
        bcH();
        if (j.isWifiNet()) {
            return eXh[new Random().nextInt(eXh.length)];
        }
        if (j.isMobileNet()) {
            if (this.eXc == 1) {
                return eXe[new Random().nextInt(eXe.length)];
            }
            if (this.eXc == 2) {
                return eXf[new Random().nextInt(eXf.length)];
            }
            if (this.eXc == 3) {
                return eXg[new Random().nextInt(eXg.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bcH() {
        try {
            this.eXd = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.eXc = 0;
        if (this.eXd != null) {
            if (this.eXd.startsWith("46000") || this.eXd.startsWith("46002") || this.eXd.startsWith("46007")) {
                this.eXc = 1;
            } else if (this.eXd.startsWith("46001") || this.eXd.startsWith("46006")) {
                this.eXc = 2;
            } else if (this.eXd.startsWith("46003") || this.eXd.startsWith("46005")) {
                this.eXc = 3;
            }
        }
    }
}
