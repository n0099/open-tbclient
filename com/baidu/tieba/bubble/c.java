package com.baidu.tieba.bubble;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.a.k;
/* loaded from: classes.dex */
final class c extends com.baidu.adp.framework.c.a {
    final /* synthetic */ BubbleChooseActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(BubbleChooseActivity bubbleChooseActivity, int i) {
        super(2010040);
        this.a = bubbleChooseActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        this.a.showToast(k.bubble_purchase_success);
        this.a.a();
    }
}
