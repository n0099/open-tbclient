package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes2.dex */
public class a {
    private volatile int eNy;
    private volatile String imsi;
    private static final String[] eNz = {"119.75.222.62", "119.75.222.63"};
    private static final String[] eNA = {"111.13.100.247", "117.185.16.61"};
    private static final String[] eNB = {"111.206.37.190"};
    private static final String[] eNC = {"115.239.211.146", "180.97.33.196"};

    /* JADX INFO: Access modifiers changed from: protected */
    public String bcb() {
        bcc();
        if (j.jT()) {
            return eNC[new Random().nextInt(eNC.length)];
        }
        if (j.jU()) {
            if (this.eNy == 1) {
                return eNz[new Random().nextInt(eNz.length)];
            }
            if (this.eNy == 2) {
                return eNA[new Random().nextInt(eNA.length)];
            }
            if (this.eNy == 3) {
                return eNB[new Random().nextInt(eNB.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bcc() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.eNy = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.eNy = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.eNy = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.eNy = 3;
            }
        }
    }
}
