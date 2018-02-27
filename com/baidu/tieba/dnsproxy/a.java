package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes3.dex */
public class a {
    private static final String[] dml = {"119.75.222.62", "119.75.222.63"};
    private static final String[] dmm = {"111.13.100.247", "117.185.16.61"};
    private static final String[] dmn = {"111.206.37.190"};
    private static final String[] dmo = {"115.239.211.146", "180.97.33.196"};
    private volatile int dmk;
    private volatile String imsi;

    /* JADX INFO: Access modifiers changed from: protected */
    public String apu() {
        apv();
        if (j.oK()) {
            return dmo[new Random().nextInt(dmo.length)];
        }
        if (j.oL()) {
            if (this.dmk == 1) {
                return dml[new Random().nextInt(dml.length)];
            }
            if (this.dmk == 2) {
                return dmm[new Random().nextInt(dmm.length)];
            }
            if (this.dmk == 3) {
                return dmn[new Random().nextInt(dmn.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void apv() {
        this.imsi = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        this.dmk = 0;
        if (this.imsi != null) {
            if (this.imsi.startsWith("46000") || this.imsi.startsWith("46002") || this.imsi.startsWith("46007")) {
                this.dmk = 1;
            } else if (this.imsi.startsWith("46001") || this.imsi.startsWith("46006")) {
                this.dmk = 2;
            } else if (this.imsi.startsWith("46003") || this.imsi.startsWith("46005")) {
                this.dmk = 3;
            }
        }
    }
}
