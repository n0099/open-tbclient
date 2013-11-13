package com.baidu.tieba.chat;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.chat.ChatData;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private String f1120a;
    private String b;
    private ChatData h;
    private com.baidu.tieba.data.chat.c l;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private ac i = null;
    private ae j = null;
    private ad k = null;

    public void a(Intent intent) {
        this.e = intent.getStringExtra("chat_com_name");
        this.d = intent.getStringExtra("chat_com_id");
        this.g = intent.getStringExtra("chat_st_type");
        this.c = intent.getStringExtra("chat_my_portrait");
        this.f = intent.getStringExtra("chat_com_portrait");
        l();
    }

    public void a(Bundle bundle) {
        this.e = bundle.getString("chat_com_name");
        this.d = bundle.getString("chat_com_id");
        this.g = bundle.getString("chat_st_type");
        this.c = bundle.getString("chat_my_portrait");
        this.f = bundle.getString("chat_com_portrait");
        l();
    }

    public void b(Bundle bundle) {
        bundle.putString("chat_com_name", this.e);
        bundle.putString("chat_com_id", this.d);
        bundle.putString("chat_st_type", this.g);
        bundle.putString("chat_my_portrait", this.c);
        bundle.putString("chat_com_portrait", this.f);
    }

    public ab() {
        this.f1120a = null;
        this.b = null;
        this.h = null;
        this.l = null;
        AccountData E = TiebaApplication.E();
        if (E != null) {
            this.b = E.getID();
            this.f1120a = E.getAccount();
        }
        this.h = new ChatData();
        this.l = com.baidu.tieba.data.chat.c.a();
    }

    private void l() {
        this.h.setFriendId(this.d);
        this.h.setUserId(this.b);
        this.h.setFriendName(this.e);
        this.h.setFriendPortrait(this.f);
        this.h.setUserPortrait(this.c);
    }

    public void a(ad adVar) {
        this.k = adVar;
    }

    public ChatData a() {
        return this.h;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public long d() {
        if (this.h.getLastMsg() == null) {
            return 0L;
        }
        return this.h.getLastMsg().getMsgId();
    }

    public String e() {
        if (this.h != null) {
            return this.h.getUserPortrait();
        }
        return null;
    }

    public String f() {
        if (this.h != null) {
            return this.h.getFriendPortrait();
        }
        return null;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return true;
    }

    public boolean g() {
        if (this.b == null || this.d == null) {
            return false;
        }
        if (this.j != null) {
            this.j.cancel();
        }
        if (this.i != null) {
            this.i.cancel();
        }
        this.j = new ae(this);
        this.j.execute(new Object[0]);
        return true;
    }

    public void h() {
        this.l.b(this.b, this.d);
    }

    public boolean i() {
        if (this.b == null || this.d == null || this.j != null) {
            return false;
        }
        this.i = new ac(this, 2);
        this.i.execute(new Object[0]);
        return true;
    }

    public boolean j() {
        if (this.b == null || this.d == null || this.j != null) {
            return false;
        }
        if (this.i != null) {
            this.i.cancel();
        }
        this.i = new ac(this, 0);
        this.i.execute(new Object[0]);
        return true;
    }

    public boolean k() {
        if (this.b == null || this.d == null || this.j != null) {
            return false;
        }
        if (this.i != null) {
            this.i.cancel();
        }
        this.i = new ac(this, 1);
        this.i.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.j != null) {
            this.j.cancel();
        }
        if (this.i != null) {
            this.i.cancel();
            return false;
        }
        return false;
    }
}
