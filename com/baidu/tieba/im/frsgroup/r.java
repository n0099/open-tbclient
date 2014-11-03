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
    final /* synthetic */ MembersActivity aYb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(MembersActivity membersActivity, int i) {
        super(i);
        this.aYb = membersActivity;
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
        ahVar = this.aYb.aXX;
        ad NS = ahVar.NS();
        this.aYb.hideProgress();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseMembersMessage)) {
            this.aYb.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseMembersMessage responseMembersMessage = (ResponseMembersMessage) socketResponsedMessage;
        Message<?> orginalMessage = responseMembersMessage.getOrginalMessage();
        if (orginalMessage == null || !(orginalMessage instanceof RequestMembersMessage)) {
            requestMembersMessage = null;
        } else {
            requestMembersMessage = (RequestMembersMessage) orginalMessage;
        }
        membersModel = this.aYb.aXY;
        membersModel.setRequestM(requestMembersMessage);
        if (responseMembersMessage.getError() != 0) {
            if (responseMembersMessage.getError() > 0) {
                if (!TextUtils.isEmpty(responseMembersMessage.getErrorString())) {
                    this.aYb.showToast(responseMembersMessage.getErrorString());
                    return;
                }
                return;
            }
            this.aYb.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        MembersData membersData = responseMembersMessage.getMembersData();
        List<UserData> users = membersData.getUsers();
        if (users != null) {
            isFirstLoad = this.aYb.isFirstLoad();
            if (isFirstLoad) {
                this.aYb.a(membersData.getPermission());
            }
            isFirstLoad2 = this.aYb.isFirstLoad();
            if (isFirstLoad2) {
                NS.bM(true);
            }
            int size = users.size();
            membersModel2 = this.aYb.aXY;
            if (size != membersModel2.getLen()) {
                NS.bO(false);
                NS.cY(false);
                isFirstLoad3 = this.aYb.isFirstLoad();
                if (isFirstLoad3 && users.size() == 0) {
                    this.aYb.NG();
                    return;
                }
            } else {
                NS.cY(true);
            }
            membersModel3 = this.aYb.aXY;
            membersModel3.addStart(users.size());
            membersModel4 = this.aYb.aXY;
            membersModel4.setLen(20);
            NS.F(users);
            NS.notifyDataSetChanged();
        }
    }
}
