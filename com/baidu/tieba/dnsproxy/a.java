package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes2.dex */
public class a {
    private static final String[] exV = {"119.75.222.62", "119.75.222.63"};
    private static final String[] exW = {"111.13.100.247", "117.185.16.61"};
    private static final String[] exX = {"111.206.37.190"};
    private static final String[] exY = {"115.239.211.146", "180.97.33.196"};
    private volatile int exU;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String aUT() {
        aUU();
        if (j.kZ()) {
            return exY[new Random().nextInt(exY.length)];
        }
        if (j.la()) {
            if (this.exU == 1) {
                return exV[new Random().nextInt(exV.length)];
            }
            if (this.exU == 2) {
                return exW[new Random().nextInt(exW.length)];
            }
            if (this.exU == 3) {
                return exX[new Random().nextInt(exX.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void aUU() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.exU = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.exU = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.exU = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.exU = 3;
            }
        }
    }
}
