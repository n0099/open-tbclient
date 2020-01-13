package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c {
    private boolean dTw = false;
    private int mChannel;

    public c() {
        aVl();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.aY(intValue, nL(intValue));
            }
        }
    }

    private int nL(int i) {
        if (i == 1) {
            return nM(i);
        }
        if (this.mChannel == 1) {
            return nO(i);
        }
        if (this.mChannel == 0) {
            return nM(i);
        }
        return 0;
    }

    private int nM(int i) {
        String nN = nN(i);
        return (!aq.isEmpty(nN) && com.baidu.tbadk.core.sharedPref.b.aDr().getInt(nN, 0) == 1) ? 1 : 0;
    }

    private String nN(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int nO(int i) {
        String nP = nP(i);
        if (aq.isEmpty(nP)) {
            return 0;
        }
        SampleResult KX = com.baidu.ubs.analytics.a.KX(nP);
        return (KX == SampleResult.T1 || KX == SampleResult.T2 || KX == SampleResult.T3 || KX == SampleResult.T4 || KX == SampleResult.T5) ? 1 : 0;
    }

    private String nP(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void aVl() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void nQ(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.aDr().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.dTw && this.mChannel == 1) {
            this.dTw = aVn();
            if (!this.dTw) {
                this.mChannel = 0;
            }
        }
    }

    public boolean aVm() {
        return this.dTw;
    }

    public boolean aVn() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().fM(TbadkCoreApplication.getInst()).tU(false).eL(30L).Ev(1).tV(false).eM(15L).Ew(1000).cVV());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
