package com.baidu.tieba.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private int WZ;
    private int bjO;
    private int bjP;
    private boolean isLocationShared;

    public boolean Rx() {
        com.baidu.tbadk.core.sharedPref.b oc = com.baidu.tbadk.core.sharedPref.b.oc();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.bjO = oc.getInt("post" + currentAccount, 0);
        this.bjP = oc.getInt("like" + currentAccount, 0);
        this.WZ = oc.getInt("group" + currentAccount, 0);
        this.isLocationShared = TbadkCoreApplication.m255getInst().getLocationShared();
        return (this.bjO == 0 && this.bjP == 0 && this.WZ == 0) ? false : true;
    }

    public void a(a aVar) {
        this.bjO = aVar.bjO;
        this.bjP = aVar.bjP;
        this.WZ = aVar.WZ;
        this.isLocationShared = aVar.isLocationShared;
    }

    public int Ry() {
        return this.bjO;
    }

    public void N(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.oc().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void Rz() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b oc = com.baidu.tbadk.core.sharedPref.b.oc();
        oc.putInt("post" + currentAccount, this.bjO);
        oc.putInt("like" + currentAccount, this.bjP);
        oc.putInt("group" + currentAccount, this.WZ);
        TbadkCoreApplication.m255getInst().setLocationShared(this.isLocationShared);
    }

    public void gs(int i) {
        if (i <= 3 && i >= 1) {
            this.bjO = i;
        }
    }

    public int RA() {
        return this.bjP;
    }

    public void gt(int i) {
        if (i <= 3 && i >= 1) {
            this.bjP = i;
        }
    }

    public int uI() {
        return this.WZ;
    }

    public void gu(int i) {
        if (i <= 3 && i >= 1) {
            this.WZ = i;
        }
    }

    public boolean RB() {
        return this.isLocationShared;
    }

    public void gv(int i) {
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
