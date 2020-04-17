package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes6.dex */
public class a {
    private static final String[] gwg = {"119.75.222.62", "119.75.222.63"};
    private static final String[] gwh = {"111.13.100.247", "117.185.16.61"};
    private static final String[] gwi = {"111.206.37.190"};
    private static final String[] gwj = {"115.239.211.146", "180.97.33.196"};
    private volatile int cCH;
    private volatile String gwf;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bGB() {
        bGC();
        if (j.isWifiNet()) {
            return gwj[new Random().nextInt(gwj.length)];
        }
        if (j.isMobileNet()) {
            if (this.cCH == 1) {
                return gwg[new Random().nextInt(gwg.length)];
            }
            if (this.cCH == 2) {
                return gwh[new Random().nextInt(gwh.length)];
            }
            if (this.cCH == 3) {
                return gwi[new Random().nextInt(gwi.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bGC() {
        try {
            this.gwf = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.cCH = 0;
        if (this.gwf != null) {
            if (this.gwf.startsWith("46000") || this.gwf.startsWith("46002") || this.gwf.startsWith("46007")) {
                this.cCH = 1;
            } else if (this.gwf.startsWith("46001") || this.gwf.startsWith("46006")) {
                this.cCH = 2;
            } else if (this.gwf.startsWith("46003") || this.gwf.startsWith("46005")) {
                this.cCH = 3;
            }
        }
    }
}
