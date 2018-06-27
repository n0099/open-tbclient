package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    private static final String[] cMk = {"119.75.222.62", "119.75.222.63"};
    private static final String[] cMl = {"111.13.100.247", "117.185.16.61"};
    private static final String[] cMm = {"111.206.37.190"};
    private static final String[] cMn = {"115.239.211.146", "180.97.33.196"};
    private volatile int cMj;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String amU() {
        amV();
        if (j.jE()) {
            return cMn[new Random().nextInt(cMn.length)];
        }
        if (j.jF()) {
            if (this.cMj == 1) {
                return cMk[new Random().nextInt(cMk.length)];
            }
            if (this.cMj == 2) {
                return cMl[new Random().nextInt(cMl.length)];
            }
            if (this.cMj == 3) {
                return cMm[new Random().nextInt(cMm.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void amV() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.cMj = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.cMj = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.cMj = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.cMj = 3;
            }
        }
    }
}
