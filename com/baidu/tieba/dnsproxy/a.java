package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    private static final String[] cOT = {"119.75.222.62", "119.75.222.63"};
    private static final String[] cOU = {"111.13.100.247", "117.185.16.61"};
    private static final String[] cOV = {"111.206.37.190"};
    private static final String[] cOW = {"115.239.211.146", "180.97.33.196"};
    private volatile int cOS;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String ant() {
        anu();
        if (j.jF()) {
            return cOW[new Random().nextInt(cOW.length)];
        }
        if (j.jG()) {
            if (this.cOS == 1) {
                return cOT[new Random().nextInt(cOT.length)];
            }
            if (this.cOS == 2) {
                return cOU[new Random().nextInt(cOU.length)];
            }
            if (this.cOS == 3) {
                return cOV[new Random().nextInt(cOV.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void anu() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.cOS = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.cOS = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.cOS = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.cOS = 3;
            }
        }
    }
}
