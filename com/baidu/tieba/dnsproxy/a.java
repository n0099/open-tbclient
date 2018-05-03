package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    private static final String[] cEr = {"119.75.222.62", "119.75.222.63"};
    private static final String[] cEs = {"111.13.100.247", "117.185.16.61"};
    private static final String[] cEt = {"111.206.37.190"};
    private static final String[] cEu = {"115.239.211.146", "180.97.33.196"};
    private volatile int cEq;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String ajD() {
        ajE();
        if (j.gQ()) {
            return cEu[new Random().nextInt(cEu.length)];
        }
        if (j.gR()) {
            if (this.cEq == 1) {
                return cEr[new Random().nextInt(cEr.length)];
            }
            if (this.cEq == 2) {
                return cEs[new Random().nextInt(cEs.length)];
            }
            if (this.cEq == 3) {
                return cEt[new Random().nextInt(cEt.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void ajE() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.cEq = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.cEq = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.cEq = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.cEq = 3;
            }
        }
    }
}
