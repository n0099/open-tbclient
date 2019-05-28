package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes2.dex */
public class a {
    private static final String[] eNA = {"119.75.222.62", "119.75.222.63"};
    private static final String[] eNB = {"111.13.100.247", "117.185.16.61"};
    private static final String[] eNC = {"111.206.37.190"};
    private static final String[] eND = {"115.239.211.146", "180.97.33.196"};
    private volatile int eNz;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bce() {
        bcf();
        if (j.jT()) {
            return eND[new Random().nextInt(eND.length)];
        }
        if (j.jU()) {
            if (this.eNz == 1) {
                return eNA[new Random().nextInt(eNA.length)];
            }
            if (this.eNz == 2) {
                return eNB[new Random().nextInt(eNB.length)];
            }
            if (this.eNz == 3) {
                return eNC[new Random().nextInt(eNC.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bcf() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.eNz = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.eNz = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.eNz = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.eNz = 3;
            }
        }
    }
}
