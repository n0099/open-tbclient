package com.baidu.tieba.im.model;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.ResponsePeerInfo;
/* loaded from: classes.dex */
public abstract class CommonPersonalMsglistModel extends MsglistModel {
    protected UserData a;
    private i e;
    private final com.baidu.adp.framework.c.g f;

    public CommonPersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.a = null;
        this.f = new g(this, 0);
        this.e = new i(this, (byte) 0);
        com.baidu.tieba.im.chat.x.b().a(this.e);
        com.baidu.adp.framework.c.a().a(205004, this.f);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        com.baidu.adp.framework.c.a().b(this.f);
        com.baidu.tieba.im.chat.x.b().b(this.e);
    }

    public final void b() {
        if (this.a != null) {
            com.baidu.tieba.im.message.ar arVar = new com.baidu.tieba.im.message.ar();
            arVar.b(this.a.getUserIdLong());
            super.sendMessage(arVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(CommonPersonalMsglistModel commonPersonalMsglistModel, com.baidu.adp.framework.message.f fVar) {
        if (fVar instanceof ResponsePeerInfo) {
            ResponsePeerInfo responsePeerInfo = (ResponsePeerInfo) fVar;
            if (responsePeerInfo.e() != 0 || responsePeerInfo.d()) {
                return;
            }
            commonPersonalMsglistModel.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        String string = this.c.getString(com.baidu.tieba.im.j.chat_permisson);
        if (this.a != null) {
            if (this.a.getSex() == 1) {
                string = string.replaceAll(this.c.getString(com.baidu.tieba.im.j.it), this.c.getString(com.baidu.tieba.im.j.he));
            } else if (this.a.getSex() == 2) {
                string = string.replaceAll(this.c.getString(com.baidu.tieba.im.j.it), this.c.getString(com.baidu.tieba.im.j.she));
            }
        }
        this.c.showToast(string, false);
        new Handler().postDelayed(new h(this), 500L);
    }

    public final void a(UserData userData) {
        this.a = userData;
    }

    public final UserData c() {
        return this.a;
    }
}
