package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes13.dex */
public class a {
    private static final String[] hqK = {"119.75.222.62", "119.75.222.63"};
    private static final String[] hqL = {"111.13.100.247", "117.185.16.61"};
    private static final String[] hqM = {"111.206.37.190"};
    private static final String[] hqN = {"115.239.211.146", "180.97.33.196"};
    private volatile int dhj;
    private volatile String hqJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public String cdz() {
        cdA();
        if (j.isWifiNet()) {
            return hqN[new Random().nextInt(hqN.length)];
        }
        if (j.isMobileNet()) {
            if (this.dhj == 1) {
                return hqK[new Random().nextInt(hqK.length)];
            }
            if (this.dhj == 2) {
                return hqL[new Random().nextInt(hqL.length)];
            }
            if (this.dhj == 3) {
                return hqM[new Random().nextInt(hqM.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void cdA() {
        try {
            this.hqJ = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.dhj = 0;
        if (this.hqJ != null) {
            if (this.hqJ.startsWith("46000") || this.hqJ.startsWith("46002") || this.hqJ.startsWith("46007")) {
                this.dhj = 1;
            } else if (this.hqJ.startsWith("46001") || this.hqJ.startsWith("46006")) {
                this.dhj = 2;
            } else if (this.hqJ.startsWith("46003") || this.hqJ.startsWith("46005")) {
                this.dhj = 3;
            }
        }
    }
}
