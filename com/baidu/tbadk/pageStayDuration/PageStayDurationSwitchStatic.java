package com.baidu.tbadk.pageStayDuration;
/* loaded from: classes.dex */
public class PageStayDurationSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.d.mA().f(PageStayDurationSwitchStatic.class);
    }

    @Override // com.baidu.adp.lib.b.a
    protected void cQ(int i) {
        e.NQ().cz(1 == i);
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "log_online_smallflow";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] mr() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ms() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mt() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mu() {
        return 10;
    }
}
