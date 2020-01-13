package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes5.dex */
public class a {
    private static final String[] fOf = {"119.75.222.62", "119.75.222.63"};
    private static final String[] fOg = {"111.13.100.247", "117.185.16.61"};
    private static final String[] fOh = {"111.206.37.190"};
    private static final String[] fOi = {"115.239.211.146", "180.97.33.196"};
    private volatile int bZq;
    private volatile String fOe;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bvd() {
        bve();
        if (j.isWifiNet()) {
            return fOi[new Random().nextInt(fOi.length)];
        }
        if (j.isMobileNet()) {
            if (this.bZq == 1) {
                return fOf[new Random().nextInt(fOf.length)];
            }
            if (this.bZq == 2) {
                return fOg[new Random().nextInt(fOg.length)];
            }
            if (this.bZq == 3) {
                return fOh[new Random().nextInt(fOh.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bve() {
        try {
            this.fOe = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.bZq = 0;
        if (this.fOe != null) {
            if (this.fOe.startsWith("46000") || this.fOe.startsWith("46002") || this.fOe.startsWith("46007")) {
                this.bZq = 1;
            } else if (this.fOe.startsWith("46001") || this.fOe.startsWith("46006")) {
                this.bZq = 2;
            } else if (this.fOe.startsWith("46003") || this.fOe.startsWith("46005")) {
                this.bZq = 3;
            }
        }
    }
}
