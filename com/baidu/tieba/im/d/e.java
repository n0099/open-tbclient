package com.baidu.tieba.im.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.model.ay;
/* loaded from: classes.dex */
public class e {
    private ay d;
    private h e;
    private double a = 0.0d;
    private double b = 0.0d;
    private BdUniqueId c = null;
    private final com.baidu.adp.lib.c.d f = new f(this);
    private final com.baidu.adp.framework.listener.d g = new g(this, 103010);

    public e(h hVar) {
        this.d = null;
        this.e = null;
        this.d = new ay(null);
        this.e = hVar;
        this.g.setTag(this.c);
        MessageManager.getInstance().registerListener(this.g);
    }

    public void a(BdUniqueId bdUniqueId) {
        this.c = bdUniqueId;
        this.d.setUniqueId(bdUniqueId);
    }

    public void a() {
        com.baidu.adp.lib.c.a.a().a(true, this.f);
    }

    public void b() {
        this.d.cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.g);
    }
}
