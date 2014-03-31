package com.baidu.tieba.discover;

import android.widget.ImageView;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class f extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || customResponsedMessage2.g() != 2007004 || customResponsedMessage2.a() == null || !(customResponsedMessage2.a() instanceof com.baidu.tbadk.mainTab.a)) {
            return;
        }
        boolean z = ((com.baidu.tbadk.mainTab.a) customResponsedMessage2.a()).a;
        imageView = DiscoverDelegateStatic.a;
        imageView.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i) {
        super(2007004);
    }
}
