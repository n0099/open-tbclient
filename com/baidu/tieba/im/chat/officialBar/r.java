package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class r extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarChatActivity aZk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.aZk = officialBarChatActivity;
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
        officialBarMsglistView = this.aZk.aZe;
        officialBarMsglistView.ct(false);
        if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
            this.aZk.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
        if (responseOfficialBarMenuMessage.hasError()) {
            if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                this.aZk.showToast(StringUtils.isNull(responseOfficialBarMenuMessage.getErrorString()) ? this.aZk.getResources().getString(com.baidu.tieba.y.neterror) : responseOfficialBarMenuMessage.getErrorString());
            } else {
                this.aZk.showToast(com.baidu.tieba.y.neterror);
            }
            officialBarMsglistModel2 = this.aZk.aZf;
            com.baidu.tieba.im.data.e officialBarMenuDatas = officialBarMsglistModel2.getOfficialBarMenuDatas();
            if (officialBarMenuDatas == null || officialBarMenuDatas.PS() == null || officialBarMenuDatas.PS().size() == 0) {
                officialBarMsglistView5 = this.aZk.aZe;
                officialBarMsglistView5.cs(true);
                return;
            }
            return;
        }
        com.baidu.tieba.im.data.e officialBarMenuDatas2 = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
        if (officialBarMenuDatas2 != null) {
            if (officialBarMenuDatas2.PQ()) {
                officialBarMsglistView3 = this.aZk.aZe;
                officialBarMsglistView3.cs(false);
                if (officialBarMenuDatas2.PS() != null && officialBarMenuDatas2.PS().size() > 0) {
                    officialBarMsglistModel = this.aZk.aZf;
                    officialBarMsglistModel.setOfficialBarMenuDatas(officialBarMenuDatas2);
                    officialBarMsglistView4 = this.aZk.aZe;
                    officialBarMsglistView4.ay(officialBarMenuDatas2.PS());
                    return;
                }
                return;
            }
            officialBarMsglistView2 = this.aZk.aZe;
            officialBarMsglistView2.cs(true);
        }
    }
}
