package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.message.NetWorkChangeMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ d apb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i) {
        super(i);
        this.apb = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdListView bdListView;
        if (customResponsedMessage.getCmd() == 2001121 && (customResponsedMessage instanceof NetWorkChangeMessage)) {
            if (((NetWorkChangeMessage) customResponsedMessage).mState == 0 || !BdSocketLinkService.isAvailable()) {
                bdListView = this.apb.aoW;
                bdListView.jI();
            }
        }
    }
}
