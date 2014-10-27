package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.model.MembersModel;
/* loaded from: classes.dex */
class t extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ MembersActivity aXN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(MembersActivity membersActivity, int i) {
        super(i);
        this.aXN = membersActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ah ahVar;
        ah ahVar2;
        MembersModel membersModel;
        ah ahVar3;
        ah ahVar4;
        ahVar = this.aXN.aXJ;
        ahVar.da(false);
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseRemoveMembersMessage)) {
            this.aXN.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage;
        if (responseRemoveMembersMessage.getError() != 0) {
            if (responseRemoveMembersMessage.getError() > 0) {
                if (!TextUtils.isEmpty(responseRemoveMembersMessage.getErrorString())) {
                    this.aXN.showToast(responseRemoveMembersMessage.getErrorString());
                    return;
                }
                return;
            }
            this.aXN.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        this.aXN.showToast(com.baidu.tieba.y.members_delete_success);
        ahVar2 = this.aXN.aXJ;
        ad NO = ahVar2.NO();
        membersModel = this.aXN.aXK;
        NO.W(membersModel.getUserIds());
        ahVar3 = this.aXN.aXJ;
        ahVar3.NP();
        ahVar4 = this.aXN.aXJ;
        ahVar4.NO().NH();
    }
}
