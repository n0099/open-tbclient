package com.baidu.tieba.im.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.model.bu;
/* loaded from: classes.dex */
public class e {
    private bu d;
    private h e;
    private double a = 0.0d;
    private double b = 0.0d;
    private int c = 0;
    private com.baidu.adp.lib.c.d f = new f(this);
    private com.baidu.adp.framework.listener.b g = new g(this, 103010);

    public e(h hVar) {
        this.d = null;
        this.e = null;
        this.d = new bu();
        this.e = hVar;
        this.g.setTag(this.c);
        MessageManager.getInstance().registerListener(this.g);
    }

    public void a(int i) {
        this.c = i;
        this.d.setUniqueId(i);
    }

    public void a() {
        com.baidu.adp.lib.c.a.a().a(true, this.f);
    }

    public void b() {
        this.d.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.g);
    }
}
