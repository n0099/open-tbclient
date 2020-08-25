package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes13.dex */
public class a {
    private static final String[] hqE = {"119.75.222.62", "119.75.222.63"};
    private static final String[] hqF = {"111.13.100.247", "117.185.16.61"};
    private static final String[] hqG = {"111.206.37.190"};
    private static final String[] hqH = {"115.239.211.146", "180.97.33.196"};
    private volatile int dhf;
    private volatile String hqD;

    /* JADX INFO: Access modifiers changed from: protected */
    public String cdy() {
        cdz();
        if (j.isWifiNet()) {
            return hqH[new Random().nextInt(hqH.length)];
        }
        if (j.isMobileNet()) {
            if (this.dhf == 1) {
                return hqE[new Random().nextInt(hqE.length)];
            }
            if (this.dhf == 2) {
                return hqF[new Random().nextInt(hqF.length)];
            }
            if (this.dhf == 3) {
                return hqG[new Random().nextInt(hqG.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void cdz() {
        try {
            this.hqD = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.dhf = 0;
        if (this.hqD != null) {
            if (this.hqD.startsWith("46000") || this.hqD.startsWith("46002") || this.hqD.startsWith("46007")) {
                this.dhf = 1;
            } else if (this.hqD.startsWith("46001") || this.hqD.startsWith("46006")) {
                this.dhf = 2;
            } else if (this.hqD.startsWith("46003") || this.hqD.startsWith("46005")) {
                this.dhf = 3;
            }
        }
    }
}
