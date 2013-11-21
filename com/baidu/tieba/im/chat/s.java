package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private String f1552a;
    private String b;
    private int c;
    private RequestRemoveMembersMessage d;

    public void a(String str, String str2, int i) {
        b(str);
        a(str2);
        a(i);
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b() {
        if (this.d != null) {
            com.baidu.tieba.im.messageCenter.f.a().b(this.d);
            this.d = null;
        }
    }

    public void a(boolean z) {
        new t(this, z).execute(new Void[0]);
    }

    public void a(com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new u(this), aVar);
    }

    public void a(long j) {
        this.d = new RequestRemoveMembersMessage();
        this.d.setGroupId(j);
        this.d.setUserIds(TiebaApplication.E().getID());
        com.baidu.tieba.im.messageCenter.f.a().a(this.d);
    }

    public String c() {
        return this.f1552a;
    }

    public long d() {
        try {
            return Long.parseLong(this.f1552a);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void b(String str) {
        this.f1552a = str;
    }

    public int e() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }
}
