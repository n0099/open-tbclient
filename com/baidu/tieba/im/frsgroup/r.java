package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.MembersData;
import com.baidu.tieba.im.message.RequestMembersMessage;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import com.baidu.tieba.im.model.MembersModel;
import java.util.List;
/* loaded from: classes.dex */
class r extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ MembersActivity aXN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(MembersActivity membersActivity, int i) {
        super(i);
        this.aXN = membersActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ah ahVar;
        RequestMembersMessage requestMembersMessage;
        MembersModel membersModel;
        boolean isFirstLoad;
        boolean isFirstLoad2;
        MembersModel membersModel2;
        MembersModel membersModel3;
        MembersModel membersModel4;
        boolean isFirstLoad3;
        ahVar = this.aXN.aXJ;
        ad NO = ahVar.NO();
        this.aXN.hideProgress();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseMembersMessage)) {
            this.aXN.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) socketResponsedMessage;
        Message<?> orginalMessage = responseMembersMessage.getOrginalMessage();
        if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
            requestMembersMessage = null;
        } else {
            requestMembersMessage = (RequestMembersMessage) orginalMessage;
        }
        membersModel = this.aXN.aXK;
        membersModel.setRequestM(requestMembersMessage);
        if (responseMembersMessage.getError() != 0) {
            if (responseMembersMessage.getError() > 0) {
                if (!TextUtils.isEmpty(responseMembersMessage.getErrorString())) {
                    this.aXN.showToast(responseMembersMessage.getErrorString());
                    return;
                }
                return;
            }
            this.aXN.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        MembersData membersData = responseMembersMessage.getMembersData();
        List<UserData> users = membersData.getUsers();
        if (users != null) {
            isFirstLoad = this.aXN.isFirstLoad();
            if (isFirstLoad) {
                this.aXN.a(membersData.getPermission());
            }
            isFirstLoad2 = this.aXN.isFirstLoad();
            if (isFirstLoad2) {
                NO.bM(true);
            }
            int size = users.size();
            membersModel2 = this.aXN.aXK;
            if (size != membersModel2.getLen()) {
                NO.bO(false);
                NO.cY(false);
                isFirstLoad3 = this.aXN.isFirstLoad();
                if (isFirstLoad3 && users.size() == 0) {
                    this.aXN.NC();
                    return;
                }
            } else {
                NO.cY(true);
            }
            membersModel3 = this.aXN.aXK;
            membersModel3.addStart(users.size());
            membersModel4 = this.aXN.aXK;
            membersModel4.setLen(20);
            NO.F(users);
            NO.notifyDataSetChanged();
        }
    }
}
