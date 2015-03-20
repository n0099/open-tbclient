package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class r extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarChatActivity aYU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aYU = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        OfficialBarMsglistView officialBarMsglistView;
        OfficialBarMsglistView officialBarMsglistView2;
        OfficialBarMsglistView officialBarMsglistView3;
        OfficialBarMsglistModel officialBarMsglistModel;
        OfficialBarMsglistView officialBarMsglistView4;
        OfficialBarMsglistModel officialBarMsglistModel2;
        OfficialBarMsglistView officialBarMsglistView5;
        officialBarMsglistView = this.aYU.aYO;
        officialBarMsglistView.cv(false);
        if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
            this.aYU.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
        if (responseOfficialBarMenuMessage.hasError()) {
            if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                this.aYU.showToast(StringUtils.isNull(responseOfficialBarMenuMessage.getErrorString()) ? this.aYU.getResources().getString(com.baidu.tieba.y.neterror) : responseOfficialBarMenuMessage.getErrorString());
            } else {
                this.aYU.showToast(com.baidu.tieba.y.neterror);
            }
            officialBarMsglistModel2 = this.aYU.aYP;
            com.baidu.tieba.im.data.e officialBarMenuDatas = officialBarMsglistModel2.getOfficialBarMenuDatas();
            if (officialBarMenuDatas == null || officialBarMenuDatas.PF() == null || officialBarMenuDatas.PF().size() == 0) {
                officialBarMsglistView5 = this.aYU.aYO;
                officialBarMsglistView5.cu(true);
                return;
            }
            return;
        }
        com.baidu.tieba.im.data.e officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
        if (officialBarMenuDatas2 != null) {
            if (officialBarMenuDatas2.PD()) {
                officialBarMsglistView3 = this.aYU.aYO;
                officialBarMsglistView3.cu(false);
                if (officialBarMenuDatas2.PF() != null && officialBarMenuDatas2.PF().size() > 0) {
                    officialBarMsglistModel = this.aYU.aYP;
                    officialBarMsglistModel.setOfficialBarMenuDatas(officialBarMenuDatas2);
                    officialBarMsglistView4 = this.aYU.aYO;
                    officialBarMsglistView4.aw(officialBarMenuDatas2.PF());
                    return;
                }
                return;
            }
            officialBarMsglistView2 = this.aYU.aYO;
            officialBarMsglistView2.cu(true);
        }
    }
}
