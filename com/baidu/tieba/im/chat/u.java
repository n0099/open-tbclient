package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.RequestDismissGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private String f1607a;
    private String b;
    private int c;
    private RequestRemoveMembersMessage d;
    private RequestDismissGroupMessage e;

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
            com.baidu.tieba.im.messageCenter.e.a().b(this.d);
            this.d = null;
        }
    }

    public void a(boolean z) {
        new v(this, z).execute(new Void[0]);
    }

    public void a(com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new w(this), aVar);
    }

    public void a(long j) {
        this.d = new RequestRemoveMembersMessage();
        this.d.setGroupId(j);
        this.d.setUserIds(TiebaApplication.F().getID());
        com.baidu.tieba.im.messageCenter.e.a().a(this.d);
    }

    public void b(long j) {
        this.e = new RequestDismissGroupMessage();
        this.e.setGroupId(j);
        com.baidu.tieba.im.messageCenter.e.a().a(this.e);
    }

    public String c() {
        return this.f1607a;
    }

    public long d() {
        return com.baidu.adp.lib.f.b.a(this.f1607a, 0L);
    }

    public void b(String str) {
        this.f1607a = str;
    }

    public int e() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }
}
