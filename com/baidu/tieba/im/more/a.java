package com.baidu.tieba.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private int Xc;
    private int bjP;
    private int bjQ;
    private boolean isLocationShared;

    public boolean RC() {
        com.baidu.tbadk.core.sharedPref.b oj = com.baidu.tbadk.core.sharedPref.b.oj();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.bjP = oj.getInt("post" + currentAccount, 0);
        this.bjQ = oj.getInt("like" + currentAccount, 0);
        this.Xc = oj.getInt("group" + currentAccount, 0);
        this.isLocationShared = TbadkCoreApplication.m255getInst().getLocationShared();
        return (this.bjP == 0 && this.bjQ == 0 && this.Xc == 0) ? false : true;
    }

    public void a(a aVar) {
        this.bjP = aVar.bjP;
        this.bjQ = aVar.bjQ;
        this.Xc = aVar.Xc;
        this.isLocationShared = aVar.isLocationShared;
    }

    public int RD() {
        return this.bjP;
    }

    public void N(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.oj().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void RE() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b oj = com.baidu.tbadk.core.sharedPref.b.oj();
        oj.putInt("post" + currentAccount, this.bjP);
        oj.putInt("like" + currentAccount, this.bjQ);
        oj.putInt("group" + currentAccount, this.Xc);
        TbadkCoreApplication.m255getInst().setLocationShared(this.isLocationShared);
    }

    public void gs(int i) {
        if (i <= 3 && i >= 1) {
            this.bjP = i;
        }
    }

    public int RF() {
        return this.bjQ;
    }

    public void gt(int i) {
        if (i <= 3 && i >= 1) {
            this.bjQ = i;
        }
    }

    public int uO() {
        return this.Xc;
    }

    public void gu(int i) {
        if (i <= 3 && i >= 1) {
            this.Xc = i;
        }
    }

    public boolean RG() {
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
