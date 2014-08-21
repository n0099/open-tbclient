package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.RequestDismissGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
/* loaded from: classes.dex */
public class bm extends com.baidu.adp.base.e {
    private String a;
    private String b;
    private int c;
    private RequestRemoveMembersMessage d;
    private RequestDismissGroupMessage e;
    private BaseActivity f;

    public bm(BaseActivity baseActivity) {
        super(baseActivity);
        this.f = null;
        this.f = baseActivity;
    }

    public void a(String str, String str2, int i) {
        b(str);
        a(str2);
        b(i);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
        if (this.d != null) {
            this.d = null;
        }
    }

    public void a(boolean z) {
        new bn(this, z).execute(new Void[0]);
    }

    public void a(com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.e.a(new bo(this), aVar);
    }

    public void a(long j) {
        this.d = new RequestRemoveMembersMessage();
        this.d.setGroupId(j);
        this.d.setUserIds(TbadkApplication.getCurrentAccountObj().getID());
        if (this.f != null) {
            this.f.sendMessage(this.d);
        } else {
            sendMessage(this.d);
        }
    }

    public void a(int i) {
        this.e = new RequestDismissGroupMessage();
        this.e.setGroupId(i);
        if (this.f != null) {
            this.f.sendMessage(this.e);
        } else {
            sendMessage(this.e);
        }
    }

    public String b() {
        return this.a;
    }

    public int c() {
        return com.baidu.adp.lib.e.c.a(this.a, 0);
    }

    public void b(String str) {
        this.a = str;
    }

    public int d() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }
}
