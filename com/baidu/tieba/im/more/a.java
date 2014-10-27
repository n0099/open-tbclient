package com.baidu.tieba.im.more;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class a {
    private int Qt;
    private int beL;
    private int beM;
    private boolean isLocationShared;

    public boolean QE() {
        com.baidu.tbadk.core.sharedPref.b lk = com.baidu.tbadk.core.sharedPref.b.lk();
        String currentAccount = TbadkApplication.getCurrentAccount();
        this.beL = lk.getInt("post" + currentAccount, 0);
        this.beM = lk.getInt("like" + currentAccount, 0);
        this.Qt = lk.getInt("group" + currentAccount, 0);
        this.isLocationShared = TbadkApplication.m251getInst().getLocationShared();
        return (this.beL == 0 && this.beM == 0 && this.Qt == 0) ? false : true;
    }

    public void a(a aVar) {
        this.beL = aVar.beL;
        this.beM = aVar.beM;
        this.Qt = aVar.Qt;
        this.isLocationShared = aVar.isLocationShared;
    }

    public int QF() {
        return this.beL;
    }

    public void H(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.lk().putInt(String.valueOf(str) + TbadkApplication.getCurrentAccount(), i);
    }

    public void QG() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b lk = com.baidu.tbadk.core.sharedPref.b.lk();
        lk.putInt("post" + currentAccount, this.beL);
        lk.putInt("like" + currentAccount, this.beM);
        lk.putInt("group" + currentAccount, this.Qt);
        TbadkApplication.m251getInst().setLocationShared(this.isLocationShared);
    }

    public void ga(int i) {
        if (i <= 3 && i >= 1) {
            this.beL = i;
        }
    }

    public int QH() {
        return this.beM;
    }

    public void gb(int i) {
        if (i <= 3 && i >= 1) {
            this.beM = i;
        }
    }

    public int qT() {
        return this.Qt;
    }

    public void gc(int i) {
        if (i <= 3 && i >= 1) {
            this.Qt = i;
        }
    }

    public boolean QI() {
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
