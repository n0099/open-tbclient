package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    private static final String[] cEu = {"119.75.222.62", "119.75.222.63"};
    private static final String[] cEv = {"111.13.100.247", "117.185.16.61"};
    private static final String[] cEw = {"111.206.37.190"};
    private static final String[] cEx = {"115.239.211.146", "180.97.33.196"};
    private volatile int cEt;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String ajD() {
        ajE();
        if (j.gQ()) {
            return cEx[new Random().nextInt(cEx.length)];
        }
        if (j.gR()) {
            if (this.cEt == 1) {
                return cEu[new Random().nextInt(cEu.length)];
            }
            if (this.cEt == 2) {
                return cEv[new Random().nextInt(cEv.length)];
            }
            if (this.cEt == 3) {
                return cEw[new Random().nextInt(cEw.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void ajE() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.cEt = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.cEt = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.cEt = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.cEt = 3;
            }
        }
    }
}
