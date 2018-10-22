package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    private static final String[] dcY = {"119.75.222.62", "119.75.222.63"};
    private static final String[] dcZ = {"111.13.100.247", "117.185.16.61"};
    private static final String[] dda = {"111.206.37.190"};
    private static final String[] ddb = {"115.239.211.146", "180.97.33.196"};
    private volatile String imsi;
    private volatile int operator;

    /* JADX INFO: Access modifiers changed from: protected */
    public String asG() {
        asH();
        if (j.kY()) {
            return ddb[new Random().nextInt(ddb.length)];
        }
        if (j.kZ()) {
            if (this.operator == 1) {
                return dcY[new Random().nextInt(dcY.length)];
            }
            if (this.operator == 2) {
                return dcZ[new Random().nextInt(dcZ.length)];
            }
            if (this.operator == 3) {
                return dda[new Random().nextInt(dda.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void asH() {
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
