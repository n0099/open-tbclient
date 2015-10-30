package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import tbclient.GetGiftMyList.DataRes;
/* loaded from: classes.dex */
class f extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ MyGiftListActivity bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(MyGiftListActivity myGiftListActivity, int i) {
        super(i);
        this.bmY = myGiftListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        m mVar;
        m mVar2;
        l lVar;
        l lVar2;
        l lVar3;
        m mVar3;
        l lVar4;
        if (socketResponsedMessage instanceof ResponseMyGiftListMessage) {
            this.bmY.closeLoadingDialog();
            mVar = this.bmY.bmT;
            mVar.getFooterView().setVisibility(8);
            ResponseMyGiftListMessage responseMyGiftListMessage = (ResponseMyGiftListMessage) socketResponsedMessage;
            mVar2 = this.bmY.bmT;
            mVar2.Qw();
            if (responseMyGiftListMessage.hasError()) {
                this.bmY.showToast(StringUtils.isNull(responseMyGiftListMessage.getErrorString()) ? this.bmY.getResources().getString(i.h.neterror) : responseMyGiftListMessage.getErrorString());
                return;
            }
            DataRes giftPageInfo = responseMyGiftListMessage.getGiftPageInfo();
            if (giftPageInfo != null) {
                lVar = this.bmY.bmS;
                lVar2 = this.bmY.bmS;
                lVar.setPageNum(lVar2.getPageNum() + 1);
                lVar3 = this.bmY.bmS;
                lVar3.setHasMore(giftPageInfo.page.has_more.intValue() == 1);
                mVar3 = this.bmY.bmT;
                lVar4 = this.bmY.bmS;
                mVar3.a(giftPageInfo, lVar4.Qu());
            }
        }
    }
}
