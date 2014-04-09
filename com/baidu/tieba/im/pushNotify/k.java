package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
final class k extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || customResponsedMessage2.g() != 2008016) {
            return;
        }
        a.d().b();
        a.d().a((ImMessageCenterShowItemData) null);
        a.d().b((ImMessageCenterShowItemData) null);
        a.d().b(false, null);
        com.baidu.adp.framework.e.c.a();
        com.baidu.adp.framework.e.c.a(true, "clear cache");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(int i) {
        super(2008016);
    }
}
