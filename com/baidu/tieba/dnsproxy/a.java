package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    private static final String[] cOq = {"119.75.222.62", "119.75.222.63"};
    private static final String[] cOr = {"111.13.100.247", "117.185.16.61"};
    private static final String[] cOs = {"111.206.37.190"};
    private static final String[] cOt = {"115.239.211.146", "180.97.33.196"};
    private volatile int cOp;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String anA() {
        anB();
        if (j.jE()) {
            return cOt[new Random().nextInt(cOt.length)];
        }
        if (j.jF()) {
            if (this.cOp == 1) {
                return cOq[new Random().nextInt(cOq.length)];
            }
            if (this.cOp == 2) {
                return cOr[new Random().nextInt(cOr.length)];
            }
            if (this.cOp == 3) {
                return cOs[new Random().nextInt(cOs.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void anB() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.cOp = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.cOp = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.cOp = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.cOp = 3;
            }
        }
    }
}
