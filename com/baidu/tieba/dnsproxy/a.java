package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes13.dex */
public class a {
    private static final String[] hdK = {"119.75.222.62", "119.75.222.63"};
    private static final String[] hdL = {"111.13.100.247", "117.185.16.61"};
    private static final String[] hdM = {"111.206.37.190"};
    private static final String[] hdN = {"115.239.211.146", "180.97.33.196"};
    private volatile int cXX;
    private volatile String hdJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bTm() {
        bTn();
        if (j.isWifiNet()) {
            return hdN[new Random().nextInt(hdN.length)];
        }
        if (j.isMobileNet()) {
            if (this.cXX == 1) {
                return hdK[new Random().nextInt(hdK.length)];
            }
            if (this.cXX == 2) {
                return hdL[new Random().nextInt(hdL.length)];
            }
            if (this.cXX == 3) {
                return hdM[new Random().nextInt(hdM.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bTn() {
        try {
            this.hdJ = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.cXX = 0;
        if (this.hdJ != null) {
            if (this.hdJ.startsWith("46000") || this.hdJ.startsWith("46002") || this.hdJ.startsWith("46007")) {
                this.cXX = 1;
            } else if (this.hdJ.startsWith("46001") || this.hdJ.startsWith("46006")) {
                this.cXX = 2;
            } else if (this.hdJ.startsWith("46003") || this.hdJ.startsWith("46005")) {
                this.cXX = 3;
            }
        }
    }
}
