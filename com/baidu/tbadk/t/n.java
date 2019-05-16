package com.baidu.tbadk.t;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
        TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i == 1);
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "check_user_name";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hy() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hz() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hA() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hB() {
        return 10;
    }
}
