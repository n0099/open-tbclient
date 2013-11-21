package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private RequestAddGroupMessage f1735a = null;
    private ResponseAddGroupMessage b = null;
    private int c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private int j;

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
        this.h = str;
    }

    public void e(String str) {
        this.i = str;
    }

    public void b(int i) {
        this.j = i;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    private RequestAddGroupMessage c() {
        RequestAddGroupMessage requestAddGroupMessage = new RequestAddGroupMessage();
        requestAddGroupMessage.setForumId(this.c);
        requestAddGroupMessage.setName(this.d);
        requestAddGroupMessage.setIntro(this.e);
        requestAddGroupMessage.setPortrait(this.f);
        requestAddGroupMessage.setPosition(this.g);
        requestAddGroupMessage.setLng(this.h);
        requestAddGroupMessage.setLat(this.i);
        requestAddGroupMessage.setGroupType(this.j);
        return requestAddGroupMessage;
    }

    public void a() {
        this.f1735a = c();
        com.baidu.tieba.im.messageCenter.f.a().a(this.f1735a);
    }

    public void b() {
        if (this.f1735a != null) {
            com.baidu.tieba.im.messageCenter.f.a().b(this.f1735a);
            this.f1735a = null;
        }
        if (this.b != null) {
            com.baidu.tieba.im.messageCenter.f.a().b(this.b);
            this.b = null;
        }
    }
}
