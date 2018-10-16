package com.baidu.tbadk.p;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void Z(int i) {
        TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i == 1);
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "check_user_name";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] iH() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iI() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iJ() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iK() {
        return 10;
    }
}
