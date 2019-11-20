package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes2.dex */
public class a {
    private static final String[] eWn = {"119.75.222.62", "119.75.222.63"};
    private static final String[] eWo = {"111.13.100.247", "117.185.16.61"};
    private static final String[] eWp = {"111.206.37.190"};
    private static final String[] eWq = {"115.239.211.146", "180.97.33.196"};
    private volatile int eWl;
    private volatile String eWm;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bcE() {
        bcF();
        if (j.isWifiNet()) {
            return eWq[new Random().nextInt(eWq.length)];
        }
        if (j.isMobileNet()) {
            if (this.eWl == 1) {
                return eWn[new Random().nextInt(eWn.length)];
            }
            if (this.eWl == 2) {
                return eWo[new Random().nextInt(eWo.length)];
            }
            if (this.eWl == 3) {
                return eWp[new Random().nextInt(eWp.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bcF() {
        try {
            this.eWm = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.eWl = 0;
        if (this.eWm != null) {
            if (this.eWm.startsWith("46000") || this.eWm.startsWith("46002") || this.eWm.startsWith("46007")) {
                this.eWl = 1;
            } else if (this.eWm.startsWith("46001") || this.eWm.startsWith("46006")) {
                this.eWl = 2;
            } else if (this.eWm.startsWith("46003") || this.eWm.startsWith("46005")) {
                this.eWl = 3;
            }
        }
    }
}
