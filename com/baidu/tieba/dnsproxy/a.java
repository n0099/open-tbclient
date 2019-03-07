package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes2.dex */
public class a {
    private static final String[] eyp = {"119.75.222.62", "119.75.222.63"};
    private static final String[] eyq = {"111.13.100.247", "117.185.16.61"};
    private static final String[] eyr = {"111.206.37.190"};
    private static final String[] eys = {"115.239.211.146", "180.97.33.196"};
    private volatile int eyo;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String aUV() {
        aUW();
        if (j.kZ()) {
            return eys[new Random().nextInt(eys.length)];
        }
        if (j.la()) {
            if (this.eyo == 1) {
                return eyp[new Random().nextInt(eyp.length)];
            }
            if (this.eyo == 2) {
                return eyq[new Random().nextInt(eyq.length)];
            }
            if (this.eyo == 3) {
                return eyr[new Random().nextInt(eyr.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void aUW() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.eyo = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.eyo = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.eyo = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.eyo = 3;
            }
        }
    }
}
