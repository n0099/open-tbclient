package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes2.dex */
public class a {
    private static final String[] eSA = {"119.75.222.62", "119.75.222.63"};
    private static final String[] eSB = {"111.13.100.247", "117.185.16.61"};
    private static final String[] eSC = {"111.206.37.190"};
    private static final String[] eSD = {"115.239.211.146", "180.97.33.196"};
    private volatile int eSz;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bef() {
        beg();
        if (j.kd()) {
            return eSD[new Random().nextInt(eSD.length)];
        }
        if (j.ke()) {
            if (this.eSz == 1) {
                return eSA[new Random().nextInt(eSA.length)];
            }
            if (this.eSz == 2) {
                return eSB[new Random().nextInt(eSB.length)];
            }
            if (this.eSz == 3) {
                return eSC[new Random().nextInt(eSC.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void beg() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        this.eSz = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.eSz = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.eSz = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.eSz = 3;
            }
        }
    }
}
