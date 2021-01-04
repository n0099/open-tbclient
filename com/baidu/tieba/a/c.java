package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private boolean gih = false;
    private int mChannel;

    public c() {
        bOj();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.by(intValue, ux(intValue));
            }
        }
    }

    private int ux(int i) {
        if (i == 1) {
            return uy(i);
        }
        if (this.mChannel == 1) {
            return uA(i);
        }
        if (this.mChannel == 0) {
            return uy(i);
        }
        return 0;
    }

    private int uy(int i) {
        String uz = uz(i);
        return (!at.isEmpty(uz) && com.baidu.tbadk.core.sharedPref.b.bvq().getInt(uz, 0) == 1) ? 1 : 0;
    }

    private String uz(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int uA(int i) {
        String uB = uB(i);
        if (at.isEmpty(uB)) {
            return 0;
        }
        SampleResult XH = com.baidu.ubs.analytics.a.XH(uB);
        return (XH == SampleResult.T1 || XH == SampleResult.T2 || XH == SampleResult.T3 || XH == SampleResult.T4 || XH == SampleResult.T5) ? 1 : 0;
    }

    private String uB(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void bOj() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.bvq().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void setChannel(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.bvq().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.gih && this.mChannel == 1) {
            this.gih = bOl();
            if (!this.gih) {
                this.mChannel = 0;
            }
        }
    }

    public boolean bOk() {
        return this.gih;
    }

    public boolean bOl() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().hn(TbadkCoreApplication.getInst()).Am(false).hR(30L).Oz(1).An(false).hS(15L).OA(1000).ejw());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
