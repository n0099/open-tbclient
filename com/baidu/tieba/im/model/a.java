package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.b {
    private int c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private int l;
    private RequestAddGroupMessage a = null;
    private ResponseAddGroupMessage b = null;
    private int m = -1;

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public void d(String str) {
        this.g = str;
    }

    public void e(String str) {
        this.h = str;
    }

    public void f(String str) {
        this.i = str;
    }

    public void g(String str) {
        this.j = str;
    }

    public void b(int i) {
        this.k = i;
    }

    public void c(int i) {
        this.l = i;
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }

    public void d(int i) {
        this.m = i;
    }

    private RequestAddGroupMessage b() {
        RequestAddGroupMessage requestAddGroupMessage = new RequestAddGroupMessage();
        requestAddGroupMessage.setForumId(this.c);
        requestAddGroupMessage.setName(this.d);
        requestAddGroupMessage.setIntro(this.e);
        requestAddGroupMessage.setPortrait(this.f);
        requestAddGroupMessage.setPosition(this.g);
        requestAddGroupMessage.setBusiness(this.h);
        requestAddGroupMessage.setLng(this.i);
        requestAddGroupMessage.setLat(this.j);
        requestAddGroupMessage.setGroupType(this.k);
        requestAddGroupMessage.setFlag(this.l);
        switch (this.m) {
            case 1011:
                requestAddGroupMessage.setPage_from_dim("neargp");
                break;
            case 1012:
                requestAddGroupMessage.setPage_from_dim("mygp");
                break;
            case 1013:
                requestAddGroupMessage.setPage_from_dim("bargp");
                break;
            case 1014:
                requestAddGroupMessage.setPage_from_dim("");
                break;
            default:
                requestAddGroupMessage.setPage_from_dim("");
                break;
        }
        return requestAddGroupMessage;
    }

    public void a() {
        this.a = b();
        super.sendMessage(this.a);
    }

    @Override // com.baidu.adp.base.b
    public void cancelMessage() {
        super.cancelMessage();
    }
}
