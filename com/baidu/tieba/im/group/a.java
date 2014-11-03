package com.baidu.tieba.im.group;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ DiscoverMoreActivity aYE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(DiscoverMoreActivity discoverMoreActivity, int i) {
        super(i);
        this.aYE = discoverMoreActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2009502 && customResponsedMessage.getData() != null) {
            this.aYE.aYD = (com.baidu.tbadk.b.a.b) customResponsedMessage.getData();
            this.aYE.NW();
        }
    }
}
