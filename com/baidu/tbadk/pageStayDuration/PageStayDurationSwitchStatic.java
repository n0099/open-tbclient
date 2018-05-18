package com.baidu.tbadk.pageStayDuration;
/* loaded from: classes.dex */
public class PageStayDurationSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.d.eE().f(PageStayDurationSwitchStatic.class);
    }

    @Override // com.baidu.adp.lib.b.a
    protected void Q(int i) {
        e.Gr().bR(1 == i);
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "log_online_smallflow";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] ev() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ew() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ex() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ey() {
        return 10;
    }
}
