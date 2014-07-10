package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class r extends CustomMessageListener {
    final /* synthetic */ EmotionManageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(EmotionManageActivity emotionManageActivity, int i) {
        super(i);
        this.a = emotionManageActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        v vVar;
        if (customResponsedMessage.getCmd() == 2001120) {
            this.a.c = new v(this.a, null);
            vVar = this.a.c;
            vVar.execute(new String[0]);
        }
    }
}
