package com.baidu.tieba.gift.giftTab;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    final /* synthetic */ GiftTabActivity bvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(GiftTabActivity giftTabActivity, int i) {
        super(i);
        this.bvt = giftTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.gift.send.a aVar;
        com.baidu.tieba.gift.send.a aVar2;
        com.baidu.tbadk.core.data.l lVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            aVar = this.bvt.bvk;
            if (aVar != null) {
                aVar2 = this.bvt.bvk;
                if (str.equalsIgnoreCase(aVar2.getOrderId())) {
                    lVar = this.bvt.bvj;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS, lVar));
                }
            }
            new com.baidu.tbadk.core.view.g(this.bvt.getPageContext()).d(this.bvt.getResources().getString(n.i.send_gift_succeed));
            Intent intent = new Intent();
            intent.putExtra(ImagesInvalidReceiver.SUCCESS, true);
            this.bvt.setResult(-1, intent);
            this.bvt.finish();
        }
    }
}
