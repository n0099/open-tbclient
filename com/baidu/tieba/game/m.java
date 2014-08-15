package com.baidu.tieba.game;

import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.framework.listener.MessageListener;
/* loaded from: classes.dex */
public class m extends com.baidu.adp.base.e {
    private int a;
    private boolean b;
    private BdBaseActivity c;

    public m(BdBaseActivity bdBaseActivity) {
        this.c = bdBaseActivity;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private RequestGameCenterMessage d(int i) {
        RequestGameCenterMessage requestGameCenterMessage = new RequestGameCenterMessage();
        requestGameCenterMessage.setPageNum(i);
        return requestGameCenterMessage;
    }

    private RequestGameCenterLocalMessage e(int i) {
        RequestGameCenterLocalMessage requestGameCenterLocalMessage = new RequestGameCenterLocalMessage();
        requestGameCenterLocalMessage.setPageNum(i);
        return requestGameCenterLocalMessage;
    }

    public void b(int i) {
        this.c.sendMessage(d(i));
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(MessageListener<?> messageListener) {
        this.c.registerListener(messageListener);
    }

    public void c(int i) {
        this.c.sendMessage(e(i));
    }

    public boolean b() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }
}
