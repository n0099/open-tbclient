package com.baidu.tieba.data;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes.dex */
public class u {
    private boolean akT;
    private String menu_name;

    public boolean zo() {
        return this.akT;
    }

    public String zp() {
        return this.menu_name;
    }

    public void a(GconAccount gconAccount) {
        if (gconAccount != null) {
            this.akT = gconAccount.has_account.intValue() == 1;
            this.menu_name = gconAccount.menu_name;
        }
    }
}
