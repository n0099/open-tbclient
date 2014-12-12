package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class t extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarChatActivity aSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aSZ = officialBarChatActivity;
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
        officialBarMsglistView = this.aSZ.aSS;
        officialBarMsglistView.cw(false);
        if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
            this.aSZ.showToast(com.baidu.tieba.z.neterror);
            return;
        }
        ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
        if (responseOfficialBarMenuMessage.hasError()) {
            if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                this.aSZ.showToast(responseOfficialBarMenuMessage.getErrorString());
            } else {
                this.aSZ.showToast(com.baidu.tieba.z.neterror);
            }
            officialBarMsglistModel2 = this.aSZ.aST;
            com.baidu.tieba.im.data.d officialBarMenuDatas = officialBarMsglistModel2.getOfficialBarMenuDatas();
            if (officialBarMenuDatas == null || officialBarMenuDatas.Mp() == null || officialBarMenuDatas.Mp().size() == 0) {
                officialBarMsglistView5 = this.aSZ.aSS;
                officialBarMsglistView5.cv(true);
                return;
            }
            return;
        }
        com.baidu.tieba.im.data.d officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
        if (officialBarMenuDatas2 != null) {
            if (officialBarMenuDatas2.Mn()) {
                officialBarMsglistView3 = this.aSZ.aSS;
                officialBarMsglistView3.cv(false);
                if (officialBarMenuDatas2.Mp() != null && officialBarMenuDatas2.Mp().size() > 0) {
                    officialBarMsglistModel = this.aSZ.aST;
                    officialBarMsglistModel.setOfficialBarMenuDatas(officialBarMenuDatas2);
                    officialBarMsglistView4 = this.aSZ.aSS;
                    officialBarMsglistView4.ak(officialBarMenuDatas2.Mp());
                    return;
                }
                return;
            }
            officialBarMsglistView2 = this.aSZ.aSS;
            officialBarMsglistView2.cv(true);
        }
    }
}
