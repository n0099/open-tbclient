package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.RequestQueryGroupLocMessage;
/* loaded from: classes.dex */
public class bv extends com.baidu.adp.base.b {
    private RequestQueryGroupLocMessage a = null;
    private int b;
    private String c;
    private String d;

    public void a(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(String str) {
        this.d = str;
    }

    private RequestQueryGroupLocMessage b() {
        RequestQueryGroupLocMessage requestQueryGroupLocMessage = new RequestQueryGroupLocMessage();
        requestQueryGroupLocMessage.setLng(this.c);
        requestQueryGroupLocMessage.setLat(this.d);
        requestQueryGroupLocMessage.setGroupId(this.b);
        return requestQueryGroupLocMessage;
    }

    public void a() {
        this.a = b();
        super.sendMessage(this.a);
    }

    @Override // com.baidu.adp.base.b
    public void cancelMessage() {
        this.a = null;
        super.cancelMessage();
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
