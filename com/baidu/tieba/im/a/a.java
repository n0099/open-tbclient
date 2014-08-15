package com.baidu.tieba.im.a;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.message.QueryGroupCountLocalMessage;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    public static boolean a = true;
    com.baidu.adp.lib.c.d b;
    private boolean c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;
    private e i;
    private final com.baidu.adp.framework.listener.d j;
    private final CustomMessageListener k;

    public a(Context context) {
        super(context);
        this.c = false;
        this.j = new b(this, 103011);
        this.k = new c(this, 2001114);
        this.b = new d(this);
    }

    public void a(e eVar) {
        this.i = eVar;
    }

    public void a() {
        if (this.c) {
            if (UtilHelper.isNetOk()) {
                com.baidu.adp.lib.c.a.a().a(true, this.b);
                return;
            } else if (this.i != null) {
                this.i.b();
                return;
            } else {
                return;
            }
        }
        this.c = true;
        MessageManager.getInstance().sendMessage(new QueryGroupCountLocalMessage());
    }

    public void b() {
        registerListener(this.j);
        registerListener(this.k);
    }

    public void c() {
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterListener(this.k);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
