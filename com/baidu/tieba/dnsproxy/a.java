package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    private static final String[] dmo = {"119.75.222.62", "119.75.222.63"};
    private static final String[] dmp = {"111.13.100.247", "117.185.16.61"};
    private static final String[] dmq = {"111.206.37.190"};
    private static final String[] dmr = {"115.239.211.146", "180.97.33.196"};
    private volatile int dmn;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String apv() {
        apw();
        if (j.oK()) {
            return dmr[new Random().nextInt(dmr.length)];
        }
        if (j.oL()) {
            if (this.dmn == 1) {
                return dmo[new Random().nextInt(dmo.length)];
            }
            if (this.dmn == 2) {
                return dmp[new Random().nextInt(dmp.length)];
            }
            if (this.dmn == 3) {
                return dmq[new Random().nextInt(dmq.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void apw() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.dmn = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.dmn = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.dmn = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.dmn = 3;
            }
        }
    }
}
