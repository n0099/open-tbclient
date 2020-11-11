package com.baidu.tieba.dnsproxy;

import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Random;
/* loaded from: classes13.dex */
public class a {
    private static final String[] ifi = {"119.75.222.62", "119.75.222.63"};
    private static final String[] ifj = {"111.13.100.247", "117.185.16.61"};
    private static final String[] ifk = {"111.206.37.190"};
    private static final String[] ifl = {"115.239.211.146", "180.97.33.196"};
    private volatile int dJH;
    private volatile String ifh;

    /* JADX INFO: Access modifiers changed from: protected */
    public String cpS() {
        cpT();
        if (j.isWifiNet()) {
            return ifl[new Random().nextInt(ifl.length)];
        }
        if (j.isMobileNet()) {
            if (this.dJH == 1) {
                return ifi[new Random().nextInt(ifi.length)];
            }
            if (this.dJH == 2) {
                return ifj[new Random().nextInt(ifj.length)];
            }
            if (this.dJH == 3) {
                return ifk[new Random().nextInt(ifk.length)];
            }
            return "119.75.222.62";
        }
        return "119.75.222.62";
    }

    protected void cpT() {
        try {
            this.ifh = ((TelephonyManager) TbadkCoreApplication.getInst().getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.dJH = 0;
        if (this.ifh != null) {
            if (this.ifh.startsWith("46000") || this.ifh.startsWith("46002") || this.ifh.startsWith("46007")) {
                this.dJH = 1;
            } else if (this.ifh.startsWith("46001") || this.ifh.startsWith("46006")) {
                this.dJH = 2;
            } else if (this.ifh.startsWith("46003") || this.ifh.startsWith("46005")) {
                this.dJH = 3;
            }
        }
    }
}
