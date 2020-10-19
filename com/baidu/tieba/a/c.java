package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes21.dex */
public class c {
    private boolean fCv = false;
    private int mChannel;

    public c() {
        bEw();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.bx(intValue, sO(intValue));
            }
        }
    }

    private int sO(int i) {
        if (i == 1) {
            return sP(i);
        }
        if (this.mChannel == 1) {
            return sR(i);
        }
        if (this.mChannel == 0) {
            return sP(i);
        }
        return 0;
    }

    private int sP(int i) {
        String sQ = sQ(i);
        return (!at.isEmpty(sQ) && com.baidu.tbadk.core.sharedPref.b.blO().getInt(sQ, 0) == 1) ? 1 : 0;
    }

    private String sQ(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int sR(int i) {
        String sS = sS(i);
        if (at.isEmpty(sS)) {
            return 0;
        }
        SampleResult Vd = com.baidu.ubs.analytics.a.Vd(sS);
        return (Vd == SampleResult.T1 || Vd == SampleResult.T2 || Vd == SampleResult.T3 || Vd == SampleResult.T4 || Vd == SampleResult.T5) ? 1 : 0;
    }

    private String sS(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void bEw() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.blO().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void sT(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.blO().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.fCv && this.mChannel == 1) {
            this.fCv = bEy();
            if (!this.fCv) {
                this.mChannel = 0;
            }
        }
    }

    public boolean bEx() {
        return this.fCv;
    }

    public boolean bEy() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().gn(TbadkCoreApplication.getInst()).yz(false).gM(30L).LO(1).yA(false).gN(15L).LP(1000).dTY());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
