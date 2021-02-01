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
    private boolean gfN = false;
    private int mChannel;

    public c() {
        bKM();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.bv(intValue, sW(intValue));
            }
        }
    }

    private int sW(int i) {
        if (i == 1) {
            return sX(i);
        }
        if (this.mChannel == 1) {
            return sZ(i);
        }
        if (this.mChannel == 0) {
            return sX(i);
        }
        return 0;
    }

    private int sX(int i) {
        String sY = sY(i);
        return (!au.isEmpty(sY) && com.baidu.tbadk.core.sharedPref.b.brQ().getInt(sY, 0) == 1) ? 1 : 0;
    }

    private String sY(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int sZ(int i) {
        String ta = ta(i);
        if (au.isEmpty(ta)) {
            return 0;
        }
        SampleResult Xy = com.baidu.ubs.analytics.a.Xy(ta);
        return (Xy == SampleResult.T1 || Xy == SampleResult.T2 || Xy == SampleResult.T3 || Xy == SampleResult.T4 || Xy == SampleResult.T5) ? 1 : 0;
    }

    private String ta(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void bKM() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void setChannel(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.gfN && this.mChannel == 1) {
            this.gfN = bKO();
            if (!this.gfN) {
                this.mChannel = 0;
            }
        }
    }

    public boolean bKN() {
        return this.gfN;
    }

    public boolean bKO() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().ho(TbadkCoreApplication.getInst()).AB(false).hU(30L).No(1).AC(false).hV(15L).Np(1000).ehX());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
