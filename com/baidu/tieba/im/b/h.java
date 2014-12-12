package com.baidu.tieba.im.b;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ b biq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b bVar, int i) {
        super(i);
        this.biq = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof BackgroundSwitchMessage) {
            if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                this.biq.Ra();
            } else {
                this.biq.QZ();
            }
        }
    }
}
