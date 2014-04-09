package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class r extends com.baidu.adp.framework.c.a {
    final /* synthetic */ EmotionManageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(EmotionManageActivity emotionManageActivity, int i) {
        super(0);
        this.a = emotionManageActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        v vVar;
        if (customResponsedMessage.g() == 2001120) {
            this.a.c = new v(this.a, (byte) 0);
            vVar = this.a.c;
            vVar.execute(new String[0]);
        }
    }
}
