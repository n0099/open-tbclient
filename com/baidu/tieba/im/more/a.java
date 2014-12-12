package com.baidu.tieba.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private int Wx;
    private int bis;
    private int bit;
    private boolean isLocationShared;

    public boolean Rg() {
        com.baidu.tbadk.core.sharedPref.b og = com.baidu.tbadk.core.sharedPref.b.og();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.bis = og.getInt("post" + currentAccount, 0);
        this.bit = og.getInt("like" + currentAccount, 0);
        this.Wx = og.getInt("group" + currentAccount, 0);
        this.isLocationShared = TbadkCoreApplication.m255getInst().getLocationShared();
        return (this.bis == 0 && this.bit == 0 && this.Wx == 0) ? false : true;
    }

    public void a(a aVar) {
        this.bis = aVar.bis;
        this.bit = aVar.bit;
        this.Wx = aVar.Wx;
        this.isLocationShared = aVar.isLocationShared;
    }

    public int Rh() {
        return this.bis;
    }

    public void N(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.og().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void Ri() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b og = com.baidu.tbadk.core.sharedPref.b.og();
        og.putInt("post" + currentAccount, this.bis);
        og.putInt("like" + currentAccount, this.bit);
        og.putInt("group" + currentAccount, this.Wx);
        TbadkCoreApplication.m255getInst().setLocationShared(this.isLocationShared);
    }

    public void gj(int i) {
        if (i <= 3 && i >= 1) {
            this.bis = i;
        }
    }

    public int Rj() {
        return this.bit;
    }

    public void gk(int i) {
        if (i <= 3 && i >= 1) {
            this.bit = i;
        }
    }

    public int ux() {
        return this.Wx;
    }

    public void gl(int i) {
        if (i <= 3 && i >= 1) {
            this.Wx = i;
        }
    }

    public boolean Rk() {
        return this.isLocationShared;
    }

    public void gm(int i) {
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
