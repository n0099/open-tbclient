package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.model.MembersModel;
/* loaded from: classes.dex */
class t extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ MembersActivity aYb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(MembersActivity membersActivity, int i) {
        super(i);
        this.aYb = membersActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ah ahVar;
        ah ahVar2;
        MembersModel membersModel;
        ah ahVar3;
        ah ahVar4;
        ahVar = this.aYb.aXX;
        ahVar.da(false);
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
            this.aYb.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
        if (responseRemoveMembersMessage.getError() != 0) {
            if (responseRemoveMembersMessage.getError() > 0) {
                if (!TextUtils.isEmpty(responseRemoveMembersMessage.getErrorString())) {
                    this.aYb.showToast(responseRemoveMembersMessage.getErrorString());
                    return;
                }
                return;
            }
            this.aYb.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        this.aYb.showToast(com.baidu.tieba.y.members_delete_success);
        ahVar2 = this.aYb.aXX;
        ad NS = ahVar2.NS();
        membersModel = this.aYb.aXY;
        NS.W(membersModel.getUserIds());
        ahVar3 = this.aYb.aXX;
        ahVar3.NT();
        ahVar4 = this.aYb.aXX;
        ahVar4.NS().NL();
    }
}
