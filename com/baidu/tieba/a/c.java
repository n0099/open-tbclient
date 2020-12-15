package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.ubs.analytics.SampleResult;
import com.baidu.ubs.analytics.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes21.dex */
public class c {
    private boolean fYA = false;
    private int mChannel;

    public c() {
        bLR();
    }

    public void a(ArrayList<Integer> arrayList, b bVar) {
        if (arrayList != null && bVar != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                bVar.bA(intValue, ul(intValue));
            }
        }
    }

    private int ul(int i) {
        if (i == 1) {
            return um(i);
        }
        if (this.mChannel == 1) {
            return uo(i);
        }
        if (this.mChannel == 0) {
            return um(i);
        }
        return 0;
    }

    private int um(int i) {
        String un = un(i);
        return (!au.isEmpty(un) && com.baidu.tbadk.core.sharedPref.b.bsO().getInt(un, 0) == 1) ? 1 : 0;
    }

    private String un(int i) {
        if (i == 1) {
            return "key_card_show_type";
        }
        if (i == 2) {
            return "key_card_abstract_switch";
        }
        return null;
    }

    private int uo(int i) {
        String up = up(i);
        if (au.isEmpty(up)) {
            return 0;
        }
        SampleResult XY = com.baidu.ubs.analytics.a.XY(up);
        return (XY == SampleResult.T1 || XY == SampleResult.T2 || XY == SampleResult.T3 || XY == SampleResult.T4 || XY == SampleResult.T5) ? 1 : 0;
    }

    private String up(int i) {
        if (i == 2) {
            return "46";
        }
        return null;
    }

    private void bLR() {
        this.mChannel = com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0);
        initSdk();
    }

    public void uq(int i) {
        if (i == 1 || i == 0) {
            this.mChannel = i;
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, this.mChannel);
            initSdk();
        }
    }

    private void initSdk() {
        if (!this.fYA && this.mChannel == 1) {
            this.fYA = bLT();
            if (!this.fYA) {
                this.mChannel = 0;
            }
        }
    }

    public boolean bLS() {
        return this.fYA;
    }

    public boolean bLT() {
        boolean z = true;
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            try {
                com.baidu.ubs.analytics.a.a(new c.a().gY(TbadkCoreApplication.getInst()).Al(false).hX(30L).OK(1).Am(false).hY(15L).OL(1000).ejm());
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
            return z;
        }
        return false;
    }
}
