package com.baidu.tieba.im.model;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.MsglistActivity;
/* loaded from: classes.dex */
public abstract class CommonPersonalMsglistModel extends MsglistModel {
    protected UserData a;
    private g b;

    public CommonPersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.a = null;
        f();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        l();
    }

    private void f() {
        this.b = new g(this, null);
        com.baidu.tieba.im.chat.w.b().a(this.b);
    }

    private void l() {
        com.baidu.tieba.im.chat.w.b().b(this.b);
    }

    public void a(UserData userData) {
        this.a = userData;
        if (this.a != null) {
            this.u = this.a.getUserIdLong();
        } else {
            this.u = 0L;
        }
    }

    public UserData c() {
        return this.a;
    }
}
