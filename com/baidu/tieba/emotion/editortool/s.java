package com.baidu.tieba.emotion.editortool;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends CustomMessageListener {
    final /* synthetic */ r bRR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i) {
        super(i);
        this.bRR = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        switch (customResponsedMessage.getCmd()) {
            case CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED /* 2001117 */:
                this.bRR.reset();
                this.bRR.setup();
                return;
            default:
                return;
        }
    }
}
