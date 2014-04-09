package com.baidu.tieba.home;

import android.os.Bundle;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class n extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.d b;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || customResponsedMessage2.g() != 2007002 || customResponsedMessage2.a() == null) {
            return;
        }
        EnterForumDelegateStatic enterForumDelegateStatic = new EnterForumDelegateStatic();
        ((com.baidu.tbadk.mainTab.e) customResponsedMessage2.a()).a(enterForumDelegateStatic);
        if (((com.baidu.tbadk.mainTab.e) customResponsedMessage2.a()).b() == null || (b = enterForumDelegateStatic.b()) == null) {
            return;
        }
        b.a.setArguments(new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(int i) {
        super(2007002);
    }
}
