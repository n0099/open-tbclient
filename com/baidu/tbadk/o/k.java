package com.baidu.tbadk.o;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
        TbadkCoreApplication.getInst().setNeedCheckUserNameDialog(i == 1);
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "check_user_name";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hm() {
        return new String[0];
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hn() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ho() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hp() {
        return 10;
    }
}
