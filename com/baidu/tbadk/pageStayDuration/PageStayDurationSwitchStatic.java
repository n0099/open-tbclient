package com.baidu.tbadk.pageStayDuration;
/* loaded from: classes.dex */
public class PageStayDurationSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.d.eV().f(PageStayDurationSwitchStatic.class);
    }

    @Override // com.baidu.adp.lib.b.a
    protected void X(int i) {
        e.FD().bS(1 == i);
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "log_online_smallflow";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eM() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eN() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eO() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eP() {
        return 10;
    }
}
