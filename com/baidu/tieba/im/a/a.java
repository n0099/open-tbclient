package com.baidu.tieba.im.a;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.j;
import com.baidu.tieba.im.message.QueryGroupCountLocalMessage;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    public static boolean bcs = true;
    private int bct;
    private int bcu;
    private e bcv;
    private final com.baidu.adp.framework.listener.e bcw;
    private final CustomMessageListener bcx;
    private String geographicLocation;
    private boolean isHaveReadCache;
    private String link;
    com.baidu.adp.lib.d.d locationCallBack;
    private String picUrl;

    public a(Context context) {
        super(context);
        this.isHaveReadCache = false;
        this.bcw = new b(this, 103011);
        this.bcx = new c(this, 2001114);
        this.locationCallBack = new d(this);
    }

    public void a(e eVar) {
        this.bcv = eVar;
    }

    public void update() {
        if (this.isHaveReadCache) {
            if (j.fh()) {
                com.baidu.adp.lib.d.a.dE().a(true, this.locationCallBack);
                return;
            } else if (this.bcv != null) {
                this.bcv.ig();
                return;
            } else {
                return;
            }
        }
        this.isHaveReadCache = true;
        MessageManager.getInstance().sendMessage(new QueryGroupCountLocalMessage());
    }

    public void onStart() {
        registerListener(this.bcw);
        registerListener(this.bcx);
    }

    public void onStop() {
        MessageManager.getInstance().unRegisterListener(this.bcw);
        MessageManager.getInstance().unRegisterListener(this.bcx);
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
