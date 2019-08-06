package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes2.dex */
public class a {
    private static final String[] eSH = {"119.75.222.62", "119.75.222.63"};
    private static final String[] eSI = {"111.13.100.247", "117.185.16.61"};
    private static final String[] eSJ = {"111.206.37.190"};
    private static final String[] eSK = {"115.239.211.146", "180.97.33.196"};
    private volatile int eSG;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String beh() {
        bei();
        if (j.kd()) {
            return eSK[new Random().nextInt(eSK.length)];
        }
        if (j.ke()) {
            if (this.eSG == 1) {
                return eSH[new Random().nextInt(eSH.length)];
            }
            if (this.eSG == 2) {
                return eSI[new Random().nextInt(eSI.length)];
            }
            if (this.eSG == 3) {
                return eSJ[new Random().nextInt(eSJ.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bei() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        this.eSG = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.eSG = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.eSG = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.eSG = 3;
            }
        }
    }
}
