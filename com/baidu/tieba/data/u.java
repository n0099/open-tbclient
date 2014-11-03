package com.baidu.tieba.data;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes.dex */
public class u {
    private boolean alc;
    private String menu_name;

    public boolean zq() {
        return this.alc;
    }

    public String zr() {
        return this.menu_name;
    }

    public void a(GconAccount gconAccount) {
        if (gconAccount != null) {
            this.alc = gconAccount.has_account.intValue() == 1;
            this.menu_name = gconAccount.menu_name;
        }
    }
}
