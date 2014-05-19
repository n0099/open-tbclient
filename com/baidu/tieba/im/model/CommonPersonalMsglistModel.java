package com.baidu.tieba.im.model;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.RequestPeerInfo;
import com.baidu.tieba.im.message.ResponsePeerInfo;
/* loaded from: classes.dex */
public abstract class CommonPersonalMsglistModel extends MsglistModel {
    protected UserData a;
    private i b;
    private final com.baidu.adp.framework.listener.b c;

    public CommonPersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.a = null;
        this.c = new g(this, 0);
        f();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        m();
    }

    public void b() {
        if (this.a != null) {
            RequestPeerInfo requestPeerInfo = new RequestPeerInfo();
            requestPeerInfo.setUid(this.a.getUserIdLong());
            super.sendMessage(requestPeerInfo);
        }
    }

    private void f() {
        this.b = new i(this, null);
        com.baidu.tieba.im.chat.x.b().a(this.b);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_GET_PEER_INFO, this.c);
    }

    private void m() {
        MessageManager.getInstance().unRegisterListener(this.c);
        com.baidu.tieba.im.chat.x.b().b(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage instanceof ResponsePeerInfo) {
            ResponsePeerInfo responsePeerInfo = (ResponsePeerInfo) responsedMessage;
            if (responsePeerInfo.getError() == 0 && !responsePeerInfo.getIsAllowed()) {
                n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        String string = this.t.getString(com.baidu.tieba.u.chat_permisson);
        if (this.a != null) {
            if (this.a.getSex() == 1) {
                string = string.replaceAll(this.t.getString(com.baidu.tieba.u.it), this.t.getString(com.baidu.tieba.u.he));
            } else if (this.a.getSex() == 2) {
                string = string.replaceAll(this.t.getString(com.baidu.tieba.u.it), this.t.getString(com.baidu.tieba.u.she));
            }
        }
        this.t.showToast(string, false);
        new Handler().postDelayed(new h(this), 500L);
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
