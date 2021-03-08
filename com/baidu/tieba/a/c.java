package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private boolean ghv = false;
    private int mChannel;

    public c() {
        bKV();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.bv(intValue, sY(intValue));
            }
        }
    }

    private int sY(int i) {
        if (i == 1) {
            return sZ(i);
        }
        if (this.mChannel == 1) {
            return tb(i);
        }
        if (this.mChannel == 0) {
            return sZ(i);
        }
        return 0;
    }

    private int sZ(int i) {
        String ta = ta(i);
        return (!au.isEmpty(ta) && com.baidu.tbadk.core.sharedPref.b.brR().getInt(ta, 0) == 1) ? 1 : 0;
    }

    private String ta(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int tb(int i) {
        String tc = tc(i);
        if (au.isEmpty(tc)) {
            return 0;
        }
        SampleResult XR = com.baidu.ubs.analytics.a.XR(tc);
        return (XR == SampleResult.T1 || XR == SampleResult.T2 || XR == SampleResult.T3 || XR == SampleResult.T4 || XR == SampleResult.T5) ? 1 : 0;
    }

    private String tc(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void bKV() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.brR().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void setChannel(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.ghv && this.mChannel == 1) {
            this.ghv = bKX();
            if (!this.ghv) {
                this.mChannel = 0;
            }
        }
    }

    public boolean bKW() {
        return this.ghv;
    }

    public boolean bKX() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().hn(TbadkCoreApplication.getInst()).AA(false).hU(30L).Nt(1).AB(false).hV(15L).Nu(1000).ein());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
