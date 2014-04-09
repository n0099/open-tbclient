package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class az extends com.baidu.adp.framework.c.a {
    final /* synthetic */ OfficialBarMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(OfficialBarMsglistModel officialBarMsglistModel, int i) {
        super(0);
        this.a = officialBarMsglistModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 != null) {
            if (customResponsedMessage2.g() == 2013003) {
                OfficialBarMsglistModel.a(this.a, (CustomResponsedMessage) customResponsedMessage2);
            } else if (customResponsedMessage2.g() == 2001148) {
                this.a.b(customResponsedMessage2);
            } else if (customResponsedMessage2.g() == 2001151) {
                OfficialBarMsglistModel.b(this.a, customResponsedMessage2);
            } else if (customResponsedMessage2.g() == 2001155) {
                String str = (String) customResponsedMessage2.a();
                if (this.a.a == null || !this.a.a.getUserId().equals(str)) {
                    return;
                }
                this.a.i();
            }
        }
    }
}
