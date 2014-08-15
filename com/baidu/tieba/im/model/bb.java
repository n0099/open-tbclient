package com.baidu.tieba.im.model;

import android.content.Context;
import com.baidu.tieba.im.message.RequestUpdateGroupAlbumMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupFlagMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupInfoMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupNameMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupPortraitMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.base.e {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private RequestUpdateGroupMessage i;
    private ResponseUpdateGroupMessage j;

    public bb(Context context) {
        super(context);
        this.g = null;
        this.h = 0;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(long j) {
        this.a = (int) j;
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

    public void b(int i) {
        this.h = i;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private RequestUpdateGroupMessage d(int i) {
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
                break;
        }
        if (requestUpdateGroupMessage != null) {
            requestUpdateGroupMessage.setGroupId(a());
            requestUpdateGroupMessage.setType(i);
        }
        return requestUpdateGroupMessage;
    }

    public void c(int i) {
        this.i = d(i);
        super.sendMessage(this.i);
    }

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
        this.i = null;
        this.j = null;
        super.cancelMessage();
    }
}
