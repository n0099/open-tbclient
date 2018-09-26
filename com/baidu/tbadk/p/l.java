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
    protected String[] ir() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int is() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int it() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iu() {
        return 10;
    }
}
