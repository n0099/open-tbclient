package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.model.OfficialBarMsglistModel;
/* loaded from: classes.dex */
class x extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ OfficialBarChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(OfficialBarChatActivity officialBarChatActivity, int i) {
        super(i);
        this.a = officialBarChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        OfficialBarMsglistView officialBarMsglistView;
        OfficialBarMsglistView officialBarMsglistView2;
        OfficialBarMsglistModel officialBarMsglistModel;
        OfficialBarMsglistView officialBarMsglistView3;
        OfficialBarMsglistModel officialBarMsglistModel2;
        OfficialBarMsglistView officialBarMsglistView4;
        officialBarMsglistView = this.a.m;
        officialBarMsglistView.d(false);
        if (!(socketResponsedMessage instanceof ResponseOfficialBarMenuMessage)) {
            this.a.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseOfficialBarMenuMessage responseOfficialBarMenuMessage = (ResponseOfficialBarMenuMessage) socketResponsedMessage;
        if (responseOfficialBarMenuMessage.hasError()) {
            if (responseOfficialBarMenuMessage.getError() > 0 && !TextUtils.isEmpty(responseOfficialBarMenuMessage.getErrorString())) {
                this.a.showToast(responseOfficialBarMenuMessage.getErrorString());
            } else {
                this.a.showToast(com.baidu.tieba.y.neterror);
            }
            officialBarMsglistModel2 = this.a.n;
            com.baidu.tieba.im.data.m f = officialBarMsglistModel2.f();
            if (f == null || f.c() == null || f.c().size() == 0) {
                officialBarMsglistView4 = this.a.m;
                officialBarMsglistView4.c(true);
                return;
            }
            return;
        }
        com.baidu.tieba.im.data.m officialBarMenuDatas = responseOfficialBarMenuMessage.getOfficialBarMenuDatas();
        if (officialBarMenuDatas != null) {
            if (!officialBarMenuDatas.a()) {
                officialBarMsglistView2 = this.a.m;
                officialBarMsglistView2.c(true);
            } else if (officialBarMenuDatas.c() != null && officialBarMenuDatas.c().size() > 0) {
                officialBarMsglistModel = this.a.n;
                officialBarMsglistModel.a(officialBarMenuDatas);
                officialBarMsglistView3 = this.a.m;
                officialBarMsglistView3.a(officialBarMenuDatas.c());
            }
        }
    }
}
