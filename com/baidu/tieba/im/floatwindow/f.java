package com.baidu.tieba.im.floatwindow;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ b aXq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b bVar) {
        super(2001011);
        this.aXq = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Boolean data;
        if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
            TbadkCoreApplication.m255getInst().setProcesBackground(data.booleanValue());
            if (data.booleanValue()) {
                this.aXq.isBackground = true;
                this.aXq.cF(false);
                return;
            }
            this.aXq.isBackground = false;
            this.aXq.cE(true);
        }
    }
}
