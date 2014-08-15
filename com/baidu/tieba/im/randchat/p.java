package com.baidu.tieba.im.randchat;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.message.RequestQuitChatRoomMessage;
import com.baidu.tieba.im.message.ResponseChatRoomInfoMessage;
import com.baidu.tieba.im.message.ResponseEnterChatRoomMessage;
import com.baidu.tieba.im.message.ResponseQuitChatRoomMessage;
import com.baidu.tieba.im.message.ResponseUpdateChatroomTopicMessage;
import com.baidu.tieba.im.model.bf;
import com.baidu.tieba.im.randchat.WaitingTipView;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class p extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(WaittingActivity waittingActivity, int i) {
        super(i);
        this.a = waittingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bf bfVar;
        bf bfVar2;
        f fVar;
        bf bfVar3;
        WaitingTipView.Type type;
        f fVar2;
        bf bfVar4;
        f fVar3;
        f fVar4;
        this.a.closeLoadingDialog();
        if (socketResponsedMessage == null) {
            this.a.showToast(x.neterror);
        } else if (socketResponsedMessage.getCmd() == 106103) {
            if (socketResponsedMessage instanceof ResponseUpdateChatroomTopicMessage) {
                ResponseUpdateChatroomTopicMessage responseUpdateChatroomTopicMessage = (ResponseUpdateChatroomTopicMessage) socketResponsedMessage;
                if (responseUpdateChatroomTopicMessage.getError() == 0) {
                    type = this.a.i;
                    if (type == WaitingTipView.Type.PERSONS_READY) {
                        fVar4 = this.a.a;
                        fVar4.b().getLoadingView().setVisibility(0);
                        return;
                    }
                    fVar2 = this.a.a;
                    com.baidu.tieba.im.view.h chatterboxView = fVar2.b().getChatterboxView();
                    bfVar4 = this.a.b;
                    chatterboxView.setTitle(bfVar4.h());
                    fVar3 = this.a.a;
                    fVar3.b().getLoadingView().setVisibility(8);
                    return;
                }
                this.a.showToast(responseUpdateChatroomTopicMessage.getErrorString());
            }
        } else if (socketResponsedMessage.getCmd() == 106102) {
            if (!(socketResponsedMessage instanceof ResponseQuitChatRoomMessage)) {
                this.a.showToast(x.neterror);
            }
            ResponseQuitChatRoomMessage responseQuitChatRoomMessage = (ResponseQuitChatRoomMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseQuitChatRoomMessage.getOrginalMessage();
            if (!(orginalMessage instanceof RequestQuitChatRoomMessage) || ((RequestQuitChatRoomMessage) orginalMessage).getChatTag() == 0) {
                if (responseQuitChatRoomMessage.getError() != 0) {
                    if (responseQuitChatRoomMessage.getError() > 0) {
                        if (!TextUtils.isEmpty(responseQuitChatRoomMessage.getErrorString())) {
                            this.a.showToast(responseQuitChatRoomMessage.getErrorString());
                        }
                    } else {
                        this.a.showToast(x.neterror);
                    }
                }
                this.a.finish();
            }
        } else if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 106101) {
            if (!(socketResponsedMessage instanceof ResponseEnterChatRoomMessage)) {
                this.a.showToast(x.neterror);
                return;
            }
            ResponseEnterChatRoomMessage responseEnterChatRoomMessage = (ResponseEnterChatRoomMessage) socketResponsedMessage;
            if (responseEnterChatRoomMessage.getError() != 0) {
                if (responseEnterChatRoomMessage.getError() > 0) {
                    if (!TextUtils.isEmpty(responseEnterChatRoomMessage.getErrorString())) {
                        this.a.showToast(responseEnterChatRoomMessage.getErrorString());
                        return;
                    }
                    return;
                }
                this.a.showToast(x.neterror);
                return;
            }
            RandChatRoomData randChatRoomData = responseEnterChatRoomMessage.getRandChatRoomData();
            this.a.a(randChatRoomData, false);
            bfVar3 = this.a.b;
            bfVar3.b(randChatRoomData);
            this.a.i();
            this.a.j();
        } else if (socketResponsedMessage.getCmd() == 106001 && (socketResponsedMessage instanceof ResponseChatRoomInfoMessage)) {
            bfVar = this.a.b;
            RandChatRoomData f = bfVar.f();
            bfVar2 = this.a.b;
            f.b(bfVar2.a((ResponseChatRoomInfoMessage) socketResponsedMessage));
            fVar = this.a.a;
            fVar.b().c();
            this.a.j();
        }
    }
}
