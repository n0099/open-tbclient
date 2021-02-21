package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes8.dex */
public class a {
    private volatile int dVj;
    private volatile String iEw;
    private static final String[] iEx = {"119.75.222.62", "119.75.222.63"};
    private static final String[] iEy = {"111.13.100.247", "117.185.16.61"};
    private static final String[] iEz = {"111.206.37.190"};
    private static final String[] iEA = {"115.239.211.146", "180.97.33.196"};

    /* JADX INFO: Access modifiers changed from: protected */
    public String cud() {
        cue();
        if (j.isWifiNet()) {
            return iEA[new Random().nextInt(iEA.length)];
        }
        if (j.isMobileNet()) {
            if (this.dVj == 1) {
                return iEx[new Random().nextInt(iEx.length)];
            }
            if (this.dVj == 2) {
                return iEy[new Random().nextInt(iEy.length)];
            }
            if (this.dVj == 3) {
                return iEz[new Random().nextInt(iEz.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void cue() {
        try {
            this.iEw = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.dVj = 0;
        if (this.iEw != null) {
            if (this.iEw.startsWith("46000") || this.iEw.startsWith("46002") || this.iEw.startsWith("46007")) {
                this.dVj = 1;
            } else if (this.iEw.startsWith("46001") || this.iEw.startsWith("46006")) {
                this.dVj = 2;
            } else if (this.iEw.startsWith("46003") || this.iEw.startsWith("46005")) {
                this.dVj = 3;
            }
        }
    }
}
