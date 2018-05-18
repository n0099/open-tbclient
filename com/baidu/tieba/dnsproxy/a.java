package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    private static final String[] cFA = {"119.75.222.62", "119.75.222.63"};
    private static final String[] cFB = {"111.13.100.247", "117.185.16.61"};
    private static final String[] cFC = {"111.206.37.190"};
    private static final String[] cFD = {"115.239.211.146", "180.97.33.196"};
    private volatile int cFz;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String ajD() {
        ajE();
        if (j.gQ()) {
            return cFD[new Random().nextInt(cFD.length)];
        }
        if (j.gR()) {
            if (this.cFz == 1) {
                return cFA[new Random().nextInt(cFA.length)];
            }
            if (this.cFz == 2) {
                return cFB[new Random().nextInt(cFB.length)];
            }
            if (this.cFz == 3) {
                return cFC[new Random().nextInt(cFC.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void ajE() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.cFz = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.cFz = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.cFz = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.cFz = 3;
            }
        }
    }
}
