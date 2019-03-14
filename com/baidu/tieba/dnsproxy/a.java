package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes2.dex */
public class a {
    private static final String[] eyk = {"119.75.222.62", "119.75.222.63"};
    private static final String[] eyl = {"111.13.100.247", "117.185.16.61"};
    private static final String[] eyn = {"111.206.37.190"};
    private static final String[] eyo = {"115.239.211.146", "180.97.33.196"};
    private volatile int eyj;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String aUV() {
        aUW();
        if (j.kZ()) {
            return eyo[new Random().nextInt(eyo.length)];
        }
        if (j.la()) {
            if (this.eyj == 1) {
                return eyk[new Random().nextInt(eyk.length)];
            }
            if (this.eyj == 2) {
                return eyl[new Random().nextInt(eyl.length)];
            }
            if (this.eyj == 3) {
                return eyn[new Random().nextInt(eyn.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void aUW() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.eyj = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.eyj = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.eyj = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.eyj = 3;
            }
        }
    }
}
