package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.RequestMyLiveListLocalMessage;
import com.baidu.tieba.im.message.RequestMyLiveListMessage;
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.base.e {
    private int a;
    private int b;
    private int c;
    private boolean d = false;

    public bc(int i) {
        this.a = i;
    }

    public boolean a() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public void b(int i) {
        this.b += i;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private RequestMyLiveListMessage c(int i, int i2) {
        RequestMyLiveListMessage requestMyLiveListMessage = new RequestMyLiveListMessage();
        requestMyLiveListMessage.setType(this.a);
        requestMyLiveListMessage.setOffset(i);
        requestMyLiveListMessage.setRn(i2);
        return requestMyLiveListMessage;
    }

    private RequestMyLiveListLocalMessage d(int i, int i2) {
        RequestMyLiveListLocalMessage requestMyLiveListLocalMessage = new RequestMyLiveListLocalMessage();
        requestMyLiveListLocalMessage.setType(this.a);
        requestMyLiveListLocalMessage.setOffset(i);
        requestMyLiveListLocalMessage.setRn(i2);
        return requestMyLiveListLocalMessage;
    }

    public void a(int i, int i2) {
        MessageManager.getInstance().sendMessage(c(i, i2));
    }

    public void b(int i, int i2) {
        MessageManager.getInstance().sendMessage(d(i, i2));
    }
}
