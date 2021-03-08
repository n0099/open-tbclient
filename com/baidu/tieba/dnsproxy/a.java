package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes7.dex */
public class a {
    private static final String[] iGg = {"119.75.222.62", "119.75.222.63"};
    private static final String[] iGh = {"111.13.100.247", "117.185.16.61"};
    private static final String[] iGi = {"111.206.37.190"};
    private static final String[] iGj = {"115.239.211.146", "180.97.33.196"};
    private volatile int dWK;
    private volatile String iGf;

    /* JADX INFO: Access modifiers changed from: protected */
    public String cuj() {
        cuk();
        if (j.isWifiNet()) {
            return iGj[new Random().nextInt(iGj.length)];
        }
        if (j.isMobileNet()) {
            if (this.dWK == 1) {
                return iGg[new Random().nextInt(iGg.length)];
            }
            if (this.dWK == 2) {
                return iGh[new Random().nextInt(iGh.length)];
            }
            if (this.dWK == 3) {
                return iGi[new Random().nextInt(iGi.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void cuk() {
        try {
            this.iGf = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.dWK = 0;
        if (this.iGf != null) {
            if (this.iGf.startsWith("46000") || this.iGf.startsWith("46002") || this.iGf.startsWith("46007")) {
                this.dWK = 1;
            } else if (this.iGf.startsWith("46001") || this.iGf.startsWith("46006")) {
                this.dWK = 2;
            } else if (this.iGf.startsWith("46003") || this.iGf.startsWith("46005")) {
                this.dWK = 3;
            }
        }
    }
}
