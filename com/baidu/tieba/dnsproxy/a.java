package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes4.dex */
public class a {
    private static final String[] fKW = {"119.75.222.62", "119.75.222.63"};
    private static final String[] fKX = {"111.13.100.247", "117.185.16.61"};
    private static final String[] fKY = {"111.206.37.190"};
    private static final String[] fKZ = {"115.239.211.146", "180.97.33.196"};
    private volatile int bZe;
    private volatile String fKV;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bub() {
        buc();
        if (j.isWifiNet()) {
            return fKZ[new Random().nextInt(fKZ.length)];
        }
        if (j.isMobileNet()) {
            if (this.bZe == 1) {
                return fKW[new Random().nextInt(fKW.length)];
            }
            if (this.bZe == 2) {
                return fKX[new Random().nextInt(fKX.length)];
            }
            if (this.bZe == 3) {
                return fKY[new Random().nextInt(fKY.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void buc() {
        try {
            this.fKV = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.bZe = 0;
        if (this.fKV != null) {
            if (this.fKV.startsWith("46000") || this.fKV.startsWith("46002") || this.fKV.startsWith("46007")) {
                this.bZe = 1;
            } else if (this.fKV.startsWith("46001") || this.fKV.startsWith("46006")) {
                this.bZe = 2;
            } else if (this.fKV.startsWith("46003") || this.fKV.startsWith("46005")) {
                this.bZe = 3;
            }
        }
    }
}
