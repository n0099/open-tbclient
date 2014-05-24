package com.baidu.tieba.im.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.message.QueryGroupCountLocalMessage;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.b {
    public static boolean a = true;
    private int d;
    private int e;
    private String f;
    private String g;
    private e h;
    private boolean c = false;
    private final com.baidu.adp.framework.listener.b i = new b(this, MessageTypes.CMD_QUERY_GROUP_COUNT);
    private final CustomMessageListener j = new c(this, MessageTypes.CMD_REQUEST_GROUP_COUNT_LOCAL);
    com.baidu.adp.lib.c.d b = new d(this);

    public void a(e eVar) {
        this.h = eVar;
    }

    public void a() {
        if (this.c) {
            if (UtilHelper.isNetOk()) {
                com.baidu.adp.lib.c.a.a().a(true, this.b);
                return;
            } else if (this.h != null) {
                this.h.f();
                return;
            } else {
                return;
            }
        }
        this.c = true;
        MessageManager.getInstance().sendMessage(new QueryGroupCountLocalMessage());
    }

    public void b() {
        a();
    }

    public void c() {
        registerListener(this.i);
        registerListener(this.j);
    }

    public void d() {
        MessageManager.getInstance().unRegisterListener(this.i);
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }
}
