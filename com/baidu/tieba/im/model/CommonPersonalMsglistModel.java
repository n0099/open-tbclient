package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.MsglistActivity;
/* loaded from: classes.dex */
public abstract class CommonPersonalMsglistModel extends MsglistModel {
    protected UserData a;
    private final CustomMessageListener b;

    public CommonPersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.a = null;
        this.b = new g(this, 0);
        f();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        m();
    }

    private void f() {
        MessageManager.getInstance().registerListener(2016012, this.b);
        MessageManager.getInstance().registerListener(2001221, this.b);
    }

    private void m() {
        MessageManager.getInstance().unRegisterListener(this.b);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public long b() {
        return com.baidu.tieba.im.memorycache.c.b().e(String.valueOf(com.baidu.tieba.im.chat.w.a), -1);
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
