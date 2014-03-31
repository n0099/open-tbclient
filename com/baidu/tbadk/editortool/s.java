package com.baidu.tbadk.editortool;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class s extends com.baidu.adp.framework.c.a {
    final /* synthetic */ EmotionTabHost a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(EmotionTabHost emotionTabHost, int i) {
        super(2001120);
        this.a = emotionTabHost;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        switch (customResponsedMessage.g()) {
            case 2001120:
                this.a.a();
                this.a.b();
                return;
            default:
                return;
        }
    }
}
