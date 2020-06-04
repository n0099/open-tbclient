package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes6.dex */
public class a {
    private static final String[] gLi = {"119.75.222.62", "119.75.222.63"};
    private static final String[] gLj = {"111.13.100.247", "117.185.16.61"};
    private static final String[] gLk = {"111.206.37.190"};
    private static final String[] gLl = {"115.239.211.146", "180.97.33.196"};
    private volatile int cOA;
    private volatile String gLh;

    /* JADX INFO: Access modifiers changed from: protected */
    public String bMV() {
        bMW();
        if (j.isWifiNet()) {
            return gLl[new Random().nextInt(gLl.length)];
        }
        if (j.isMobileNet()) {
            if (this.cOA == 1) {
                return gLi[new Random().nextInt(gLi.length)];
            }
            if (this.cOA == 2) {
                return gLj[new Random().nextInt(gLj.length)];
            }
            if (this.cOA == 3) {
                return gLk[new Random().nextInt(gLk.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void bMW() {
        try {
            this.gLh = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.cOA = 0;
        if (this.gLh != null) {
            if (this.gLh.startsWith("46000") || this.gLh.startsWith("46002") || this.gLh.startsWith("46007")) {
                this.cOA = 1;
            } else if (this.gLh.startsWith("46001") || this.gLh.startsWith("46006")) {
                this.cOA = 2;
            } else if (this.gLh.startsWith("46003") || this.gLh.startsWith("46005")) {
                this.cOA = 3;
            }
        }
    }
}
