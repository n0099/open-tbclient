package com.baidu.tbadk.editortool;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
class s extends CustomMessageListener {
    final /* synthetic */ EmotionTabHost a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(EmotionTabHost emotionTabHost, int i) {
        super(i);
        this.a = emotionTabHost;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        switch (customResponsedMessage.getCmd()) {
            case MessageTypes.CMD_EMOTIONS_GROUP_CHANGED /* 2003120 */:
                this.a.a();
                this.a.b();
                return;
            default:
                return;
        }
    }
}
