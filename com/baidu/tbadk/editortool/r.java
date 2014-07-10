package com.baidu.tbadk.editortool;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class r extends CustomMessageListener {
    final /* synthetic */ EmotionTabHost a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(EmotionTabHost emotionTabHost, int i) {
        super(i);
        this.a = emotionTabHost;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        switch (customResponsedMessage.getCmd()) {
            case 2001120:
                this.a.a();
                this.a.b();
                return;
            default:
                return;
        }
    }
}
