package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes13.dex */
public class a {
    private static final String[] ifX = {"119.75.222.62", "119.75.222.63"};
    private static final String[] ifY = {"111.13.100.247", "117.185.16.61"};
    private static final String[] ifZ = {"111.206.37.190"};
    private static final String[] iga = {"115.239.211.146", "180.97.33.196"};
    private volatile int dHZ;
    private volatile String ifW;

    /* JADX INFO: Access modifiers changed from: protected */
    public String cpv() {
        cpw();
        if (j.isWifiNet()) {
            return iga[new Random().nextInt(iga.length)];
        }
        if (j.isMobileNet()) {
            if (this.dHZ == 1) {
                return ifX[new Random().nextInt(ifX.length)];
            }
            if (this.dHZ == 2) {
                return ifY[new Random().nextInt(ifY.length)];
            }
            if (this.dHZ == 3) {
                return ifZ[new Random().nextInt(ifZ.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void cpw() {
        try {
            this.ifW = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.dHZ = 0;
        if (this.ifW != null) {
            if (this.ifW.startsWith("46000") || this.ifW.startsWith("46002") || this.ifW.startsWith("46007")) {
                this.dHZ = 1;
            } else if (this.ifW.startsWith("46001") || this.ifW.startsWith("46006")) {
                this.dHZ = 2;
            } else if (this.ifW.startsWith("46003") || this.ifW.startsWith("46005")) {
                this.dHZ = 3;
            }
        }
    }
}
