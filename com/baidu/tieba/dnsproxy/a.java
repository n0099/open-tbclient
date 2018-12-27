package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    private static final String[] dnD = {"119.75.222.62", "119.75.222.63"};
    private static final String[] dnE = {"111.13.100.247", "117.185.16.61"};
    private static final String[] dnF = {"111.206.37.190"};
    private static final String[] dnG = {"115.239.211.146", "180.97.33.196"};
    private volatile String imsi;
    private volatile int operator;

    /* JADX INFO: Access modifiers changed from: protected */
    public String auG() {
        auH();
        if (j.kW()) {
            return dnG[new Random().nextInt(dnG.length)];
        }
        if (j.kX()) {
            if (this.operator == 1) {
                return dnD[new Random().nextInt(dnD.length)];
            }
            if (this.operator == 2) {
                return dnE[new Random().nextInt(dnE.length)];
            }
            if (this.operator == 3) {
                return dnF[new Random().nextInt(dnF.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void auH() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.operator = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.operator = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.operator = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.operator = 3;
            }
        }
    }
}
