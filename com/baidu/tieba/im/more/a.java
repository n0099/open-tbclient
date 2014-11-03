package com.baidu.tieba.im.more;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class a {
    private int Qx;
    private int beZ;
    private int bfa;
    private boolean isLocationShared;

    public boolean QH() {
        com.baidu.tbadk.core.sharedPref.b lk = com.baidu.tbadk.core.sharedPref.b.lk();
        String currentAccount = TbadkApplication.getCurrentAccount();
        this.beZ = lk.getInt("post" + currentAccount, 0);
        this.bfa = lk.getInt("like" + currentAccount, 0);
        this.Qx = lk.getInt("group" + currentAccount, 0);
        this.isLocationShared = TbadkApplication.m251getInst().getLocationShared();
        return (this.beZ == 0 && this.bfa == 0 && this.Qx == 0) ? false : true;
    }

    public void a(a aVar) {
        this.beZ = aVar.beZ;
        this.bfa = aVar.bfa;
        this.Qx = aVar.Qx;
        this.isLocationShared = aVar.isLocationShared;
    }

    public int QI() {
        return this.beZ;
    }

    public void H(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.lk().putInt(String.valueOf(str) + TbadkApplication.getCurrentAccount(), i);
    }

    public void QJ() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b lk = com.baidu.tbadk.core.sharedPref.b.lk();
        lk.putInt("post" + currentAccount, this.beZ);
        lk.putInt("like" + currentAccount, this.bfa);
        lk.putInt("group" + currentAccount, this.Qx);
        TbadkApplication.m251getInst().setLocationShared(this.isLocationShared);
    }

    public void ga(int i) {
        if (i <= 3 && i >= 1) {
            this.beZ = i;
        }
    }

    public int QK() {
        return this.bfa;
    }

    public void gb(int i) {
        if (i <= 3 && i >= 1) {
            this.bfa = i;
        }
    }

    public int qV() {
        return this.Qx;
    }

    public void gc(int i) {
        if (i <= 3 && i >= 1) {
            this.Qx = i;
        }
    }

    public boolean QL() {
        return this.isLocationShared;
    }

    public void gd(int i) {
        switch (i) {
            case 1:
                this.isLocationShared = true;
                return;
            default:
                this.isLocationShared = false;
                return;
        }
    }
}
