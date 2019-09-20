package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes2.dex */
public class a {
    private static final String[] eUo = {"119.75.222.62", "119.75.222.63"};
    private static final String[] eUp = {"111.13.100.247", "117.185.16.61"};
    private static final String[] eUq = {"111.206.37.190"};
    private static final String[] eUr = {"115.239.211.146", "180.97.33.196"};
    private volatile int eUn;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String beL() {
        beM();
        if (j.kd()) {
            return eUr[new Random().nextInt(eUr.length)];
        }
        if (j.ke()) {
            if (this.eUn == 1) {
                return eUo[new Random().nextInt(eUo.length)];
            }
            if (this.eUn == 2) {
                return eUp[new Random().nextInt(eUp.length)];
            }
            if (this.eUn == 3) {
                return eUq[new Random().nextInt(eUq.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void beM() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        this.eUn = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.eUn = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.eUn = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.eUn = 3;
            }
        }
    }
}
