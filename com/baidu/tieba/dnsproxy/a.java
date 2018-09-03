package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    private static final String[] cOQ = {"119.75.222.62", "119.75.222.63"};
    private static final String[] cOR = {"111.13.100.247", "117.185.16.61"};
    private static final String[] cOS = {"111.206.37.190"};
    private static final String[] cOT = {"115.239.211.146", "180.97.33.196"};
    private volatile int cOP;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String anv() {
        anw();
        if (j.jF()) {
            return cOT[new Random().nextInt(cOT.length)];
        }
        if (j.jG()) {
            if (this.cOP == 1) {
                return cOQ[new Random().nextInt(cOQ.length)];
            }
            if (this.cOP == 2) {
                return cOR[new Random().nextInt(cOR.length)];
            }
            if (this.cOP == 3) {
                return cOS[new Random().nextInt(cOS.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void anw() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.cOP = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.cOP = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.cOP = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.cOP = 3;
            }
        }
    }
}
