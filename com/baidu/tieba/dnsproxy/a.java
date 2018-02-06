package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    private volatile int dmw;
    private volatile String imsi;
    private static final String[] dmx = {"119.75.222.62", "119.75.222.63"};
    private static final String[] dmy = {"111.13.100.247", "117.185.16.61"};
    private static final String[] dmz = {"111.206.37.190"};
    private static final String[] dmA = {"115.239.211.146", "180.97.33.196"};

    /* JADX INFO: Access modifiers changed from: protected */
    public String apv() {
        apw();
        if (j.oK()) {
            return dmA[new Random().nextInt(dmA.length)];
        }
        if (j.oL()) {
            if (this.dmw == 1) {
                return dmx[new Random().nextInt(dmx.length)];
            }
            if (this.dmw == 2) {
                return dmy[new Random().nextInt(dmy.length)];
            }
            if (this.dmw == 3) {
                return dmz[new Random().nextInt(dmz.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void apw() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.dmw = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.dmw = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.dmw = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.dmw = 3;
            }
        }
    }
}
