package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    private static final String[] cUH = {"119.75.222.62", "119.75.222.63"};
    private static final String[] cUI = {"111.13.100.247", "117.185.16.61"};
    private static final String[] cUJ = {"111.206.37.190"};
    private static final String[] cUK = {"115.239.211.146", "180.97.33.196"};
    private volatile int cUG;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String aph() {
        apj();
        if (j.kL()) {
            return cUK[new Random().nextInt(cUK.length)];
        }
        if (j.kM()) {
            if (this.cUG == 1) {
                return cUH[new Random().nextInt(cUH.length)];
            }
            if (this.cUG == 2) {
                return cUI[new Random().nextInt(cUI.length)];
            }
            if (this.cUG == 3) {
                return cUJ[new Random().nextInt(cUJ.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void apj() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.cUG = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.cUG = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.cUG = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.cUG = 3;
            }
        }
    }
}
