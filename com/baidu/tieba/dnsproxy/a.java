package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes7.dex */
public class a {
    private volatile int dTd;
    private volatile String iyy;
    private static final String[] iyz = {"119.75.222.62", "119.75.222.63"};
    private static final String[] iyA = {"111.13.100.247", "117.185.16.61"};
    private static final String[] iyB = {"111.206.37.190"};
    private static final String[] iyC = {"115.239.211.146", "180.97.33.196"};

    /* JADX INFO: Access modifiers changed from: protected */
    public String csK() {
        csL();
        if (j.isWifiNet()) {
            return iyC[new Random().nextInt(iyC.length)];
        }
        if (j.isMobileNet()) {
            if (this.dTd == 1) {
                return iyz[new Random().nextInt(iyz.length)];
            }
            if (this.dTd == 2) {
                return iyA[new Random().nextInt(iyA.length)];
            }
            if (this.dTd == 3) {
                return iyB[new Random().nextInt(iyB.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void csL() {
        try {
            this.iyy = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.dTd = 0;
        if (this.iyy != null) {
            if (this.iyy.startsWith("46000") || this.iyy.startsWith("46002") || this.iyy.startsWith("46007")) {
                this.dTd = 1;
            } else if (this.iyy.startsWith("46001") || this.iyy.startsWith("46006")) {
                this.dTd = 2;
            } else if (this.iyy.startsWith("46003") || this.iyy.startsWith("46005")) {
                this.dTd = 3;
            }
        }
    }
}
