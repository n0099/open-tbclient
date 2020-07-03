package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes6.dex */
public class a {
    private static final String[] gYf = {"119.75.222.62", "119.75.222.63"};
    private static final String[] gYg = {"111.13.100.247", "117.185.16.61"};
    private static final String[] gYh = {"111.206.37.190"};
    private static final String[] gYi = {"115.239.211.146", "180.97.33.196"};
    private volatile int cTk;
    private volatile String gYe;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bQa() {
        bQb();
        if (j.isWifiNet()) {
            return gYi[new Random().nextInt(gYi.length)];
        }
        if (j.isMobileNet()) {
            if (this.cTk == 1) {
                return gYf[new Random().nextInt(gYf.length)];
            }
            if (this.cTk == 2) {
                return gYg[new Random().nextInt(gYg.length)];
            }
            if (this.cTk == 3) {
                return gYh[new Random().nextInt(gYh.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bQb() {
        try {
            this.gYe = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.cTk = 0;
        if (this.gYe != null) {
            if (this.gYe.startsWith("46000") || this.gYe.startsWith("46002") || this.gYe.startsWith("46007")) {
                this.cTk = 1;
            } else if (this.gYe.startsWith("46001") || this.gYe.startsWith("46006")) {
                this.cTk = 2;
            } else if (this.gYe.startsWith("46003") || this.gYe.startsWith("46005")) {
                this.cTk = 3;
            }
        }
    }
}
