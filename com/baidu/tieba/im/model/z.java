package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.RequestQueryGroupLocMessage;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private RequestQueryGroupLocMessage f1832a = null;
    private ResponseRequestGroupLocMessage b = null;
    private int c;
    private String d;
    private String e;

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.e = str;
    }

    private RequestQueryGroupLocMessage c() {
        RequestQueryGroupLocMessage requestQueryGroupLocMessage = new RequestQueryGroupLocMessage();
        requestQueryGroupLocMessage.setLng(this.d);
        requestQueryGroupLocMessage.setLat(this.e);
        requestQueryGroupLocMessage.setGroupId(this.c);
        return requestQueryGroupLocMessage;
    }

    public void a() {
        this.f1832a = c();
        com.baidu.tieba.im.messageCenter.e.a().a(this.f1832a);
    }

    public void b() {
        if (this.f1832a != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.f1832a);
            this.f1832a = null;
        }
        if (this.b != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.b);
            this.b = null;
        }
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }
}
