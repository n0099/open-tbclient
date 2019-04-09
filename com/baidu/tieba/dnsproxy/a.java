package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes2.dex */
public class a {
    private static final String[] exW = {"119.75.222.62", "119.75.222.63"};
    private static final String[] exX = {"111.13.100.247", "117.185.16.61"};
    private static final String[] exY = {"111.206.37.190"};
    private static final String[] exZ = {"115.239.211.146", "180.97.33.196"};
    private volatile int exV;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String aUT() {
        aUU();
        if (j.kZ()) {
            return exZ[new Random().nextInt(exZ.length)];
        }
        if (j.la()) {
            if (this.exV == 1) {
                return exW[new Random().nextInt(exW.length)];
            }
            if (this.exV == 2) {
                return exX[new Random().nextInt(exX.length)];
            }
            if (this.exV == 3) {
                return exY[new Random().nextInt(exY.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void aUU() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.exV = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.exV = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.exV = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.exV = 3;
            }
        }
    }
}
