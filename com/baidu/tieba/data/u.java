package com.baidu.tieba.data;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes.dex */
public class u {
    private boolean a;
    private String b;

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public void a(GconAccount gconAccount) {
        if (gconAccount != null) {
            this.a = gconAccount.has_account.intValue() == 1;
            this.b = gconAccount.menu_name;
        }
    }
}
