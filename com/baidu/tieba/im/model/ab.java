package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.RequestUpdateGroupAlbumMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupFlagMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupInfoMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupNameMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupPortraitMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private long f1809a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g = null;
    private int h = 0;
    private RequestUpdateGroupMessage i;
    private ResponseUpdateGroupMessage j;

    public long a() {
        return this.f1809a;
    }

    public void a(long j) {
        this.f1809a = j;
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

    public String f() {
        return this.f;
    }

    public void e(String str) {
        this.f = str;
    }

    public String g() {
        return this.g;
    }

    public void f(String str) {
        this.g = str;
    }

    public int h() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
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
                requestUpdateGroupMessage = new RequestUpdateGroupAlbumMessage(g());
                break;
            case 4:
                requestUpdateGroupMessage = new RequestUpdateGroupPortraitMessage(d());
                break;
            case 5:
                requestUpdateGroupMessage = new RequestUpdateGroupFlagMessage(h(), e(), f());
            default:
                com.baidu.adp.lib.h.e.a("no right type");
                break;
        }
        if (requestUpdateGroupMessage != null) {
            requestUpdateGroupMessage.setGroupId(a());
            requestUpdateGroupMessage.setType(i);
        }
        return requestUpdateGroupMessage;
    }

    public void b(int i) {
        this.i = c(i);
        com.baidu.tieba.im.messageCenter.e.a().a(this.i);
    }

    public void i() {
        if (this.i != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.i);
            this.i = null;
        }
        if (this.j != null) {
            com.baidu.tieba.im.messageCenter.e.a().b(this.j);
            this.j = null;
        }
    }
}
