package com.baidu.tbadk.t;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void C(int i) {
        TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i == 1);
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "check_user_name";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] fi() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fj() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fk() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fl() {
        return 10;
    }
}
