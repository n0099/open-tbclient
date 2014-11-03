package com.baidu.tieba.im.a;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.j;
import com.baidu.tieba.im.message.QueryGroupCountLocalMessage;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    public static boolean bcG = true;
    private int bcH;
    private int bcI;
    private e bcJ;
    private final com.baidu.adp.framework.listener.e bcK;
    private final CustomMessageListener bcL;
    private String geographicLocation;
    private boolean isHaveReadCache;
    private String link;
    com.baidu.adp.lib.d.d locationCallBack;
    private String picUrl;

    public a(Context context) {
        super(context);
        this.isHaveReadCache = false;
        this.bcK = new b(this, 103011);
        this.bcL = new c(this, 2001114);
        this.locationCallBack = new d(this);
    }

    public void a(e eVar) {
        this.bcJ = eVar;
    }

    public void update() {
        if (this.isHaveReadCache) {
            if (j.fh()) {
                com.baidu.adp.lib.d.a.dE().a(true, this.locationCallBack);
                return;
            } else if (this.bcJ != null) {
                this.bcJ.ig();
                return;
            } else {
                return;
            }
        }
        this.isHaveReadCache = true;
        MessageManager.getInstance().sendMessage(new QueryGroupCountLocalMessage());
    }

    public void onStart() {
        registerListener(this.bcK);
        registerListener(this.bcL);
    }

    public void onStop() {
        MessageManager.getInstance().unRegisterListener(this.bcK);
        MessageManager.getInstance().unRegisterListener(this.bcL);
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
