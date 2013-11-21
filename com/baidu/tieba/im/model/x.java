package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.RequestUpdateGroupAlbumMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupFlagMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupInfoMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupNameMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupPortraitMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private long f1754a;
    private String b;
    private String c;
    private String d;
    private String e = null;
    private int f = 0;
    private RequestUpdateGroupMessage g;
    private ResponseUpdateGroupMessage h;

    public long a() {
        return this.f1754a;
    }

    public void a(long j) {
        this.f1754a = j;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public String d() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public String e() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    public int f() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    private RequestUpdateGroupMessage c(int i) {
        RequestUpdateGroupMessage requestUpdateGroupMessage = null;
        switch (i) {
            case 1:
                requestUpdateGroupMessage = new RequestUpdateGroupInfoMessage(c());
                break;
            case 2:
                requestUpdateGroupMessage = new RequestUpdateGroupNameMessage(b());
                break;
            case 3:
                requestUpdateGroupMessage = new RequestUpdateGroupAlbumMessage(e());
                break;
            case 4:
                requestUpdateGroupMessage = new RequestUpdateGroupPortraitMessage(d());
                break;
            case 5:
                requestUpdateGroupMessage = new RequestUpdateGroupFlagMessage(f());
            default:
                com.baidu.adp.lib.h.d.a("no right type");
                break;
        }
        if (requestUpdateGroupMessage != null) {
            requestUpdateGroupMessage.setGroupId(a());
        }
        return requestUpdateGroupMessage;
    }

    public void b(int i) {
        this.g = c(i);
        com.baidu.tieba.im.messageCenter.f.a().a(this.g);
    }

    public void g() {
        if (this.g != null) {
            com.baidu.tieba.im.messageCenter.f.a().b(this.g);
            this.g = null;
        }
        if (this.h != null) {
            com.baidu.tieba.im.messageCenter.f.a().b(this.h);
            this.h = null;
        }
    }
}
