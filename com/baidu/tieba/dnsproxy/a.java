package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes13.dex */
public class a {
    private static final String[] hMK = {"119.75.222.62", "119.75.222.63"};
    private static final String[] hML = {"111.13.100.247", "117.185.16.61"};
    private static final String[] hMM = {"111.206.37.190"};
    private static final String[] hMN = {"115.239.211.146", "180.97.33.196"};
    private volatile int dvs;
    private volatile String hMJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public String ckk() {
        ckl();
        if (j.isWifiNet()) {
            return hMN[new Random().nextInt(hMN.length)];
        }
        if (j.isMobileNet()) {
            if (this.dvs == 1) {
                return hMK[new Random().nextInt(hMK.length)];
            }
            if (this.dvs == 2) {
                return hML[new Random().nextInt(hML.length)];
            }
            if (this.dvs == 3) {
                return hMM[new Random().nextInt(hMM.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void ckl() {
        try {
            this.hMJ = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.dvs = 0;
        if (this.hMJ != null) {
            if (this.hMJ.startsWith("46000") || this.hMJ.startsWith("46002") || this.hMJ.startsWith("46007")) {
                this.dvs = 1;
            } else if (this.hMJ.startsWith("46001") || this.hMJ.startsWith("46006")) {
                this.dvs = 2;
            } else if (this.hMJ.startsWith("46003") || this.hMJ.startsWith("46005")) {
                this.dvs = 3;
            }
        }
    }
}
