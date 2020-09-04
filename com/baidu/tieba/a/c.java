package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes15.dex */
public class c {
    private boolean fnd = false;
    private int mChannel;

    public c() {
        bAy();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.by(intValue, rY(intValue));
            }
        }
    }

    private int rY(int i) {
        if (i == 1) {
            return rZ(i);
        }
        if (this.mChannel == 1) {
            return sb(i);
        }
        if (this.mChannel == 0) {
            return rZ(i);
        }
        return 0;
    }

    private int rZ(int i) {
        String sa = sa(i);
        return (!at.isEmpty(sa) && com.baidu.tbadk.core.sharedPref.b.bik().getInt(sa, 0) == 1) ? 1 : 0;
    }

    private String sa(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int sb(int i) {
        String sc = sc(i);
        if (at.isEmpty(sc)) {
            return 0;
        }
        SampleResult TN = com.baidu.ubs.analytics.a.TN(sc);
        return (TN == SampleResult.T1 || TN == SampleResult.T2 || TN == SampleResult.T3 || TN == SampleResult.T4 || TN == SampleResult.T5) ? 1 : 0;
    }

    private String sc(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void bAy() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void sd(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.fnd && this.mChannel == 1) {
            this.fnd = bAA();
            if (!this.fnd) {
                this.mChannel = 0;
            }
        }
    }

    public boolean bAz() {
        return this.fnd;
    }

    public boolean bAA() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().fZ(TbadkCoreApplication.getInst()).xJ(false).gg(30L).KD(1).xK(false).gh(15L).KE(1000).dMp());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
