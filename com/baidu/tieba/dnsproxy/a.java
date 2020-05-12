package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes6.dex */
public class a {
    private static final String[] gwm = {"119.75.222.62", "119.75.222.63"};
    private static final String[] gwn = {"111.13.100.247", "117.185.16.61"};
    private static final String[] gwo = {"111.206.37.190"};
    private static final String[] gwp = {"115.239.211.146", "180.97.33.196"};
    private volatile int cCN;
    private volatile String gwl;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bGA() {
        bGB();
        if (j.isWifiNet()) {
            return gwp[new Random().nextInt(gwp.length)];
        }
        if (j.isMobileNet()) {
            if (this.cCN == 1) {
                return gwm[new Random().nextInt(gwm.length)];
            }
            if (this.cCN == 2) {
                return gwn[new Random().nextInt(gwn.length)];
            }
            if (this.cCN == 3) {
                return gwo[new Random().nextInt(gwo.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bGB() {
        try {
            this.gwl = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.cCN = 0;
        if (this.gwl != null) {
            if (this.gwl.startsWith("46000") || this.gwl.startsWith("46002") || this.gwl.startsWith("46007")) {
                this.cCN = 1;
            } else if (this.gwl.startsWith("46001") || this.gwl.startsWith("46006")) {
                this.cCN = 2;
            } else if (this.gwl.startsWith("46003") || this.gwl.startsWith("46005")) {
                this.cCN = 3;
            }
        }
    }
}
