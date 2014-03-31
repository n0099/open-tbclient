package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class p extends com.baidu.adp.framework.c.a {
    final /* synthetic */ EmotionManageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(EmotionManageActivity emotionManageActivity, int i) {
        super(0);
        this.a = emotionManageActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        t tVar;
        if (customResponsedMessage.g() == 2001120) {
            this.a.c = new t(this.a, (byte) 0);
            tVar = this.a.c;
            tVar.execute(new String[0]);
        }
    }
}
