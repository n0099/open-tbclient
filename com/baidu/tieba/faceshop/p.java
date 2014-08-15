package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class p extends CustomMessageListener {
    final /* synthetic */ EmotionManageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(EmotionManageActivity emotionManageActivity, int i) {
        super(i);
        this.a = emotionManageActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        t tVar;
        if (customResponsedMessage.getCmd() == 2001120) {
            this.a.c = new t(this.a, null);
            tVar = this.a.c;
            tVar.execute(new String[0]);
        }
    }
}
