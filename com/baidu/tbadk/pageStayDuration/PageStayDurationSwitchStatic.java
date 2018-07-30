package com.baidu.tbadk.pageStayDuration;
/* loaded from: classes.dex */
public class PageStayDurationSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.d.hv().f(PageStayDurationSwitchStatic.class);
    }

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
        e.Km().bW(1 == i);
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "log_online_smallflow";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hl() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hm() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hn() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ho() {
        return 10;
    }
}
