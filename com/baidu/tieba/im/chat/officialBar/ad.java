package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* loaded from: classes.dex */
final class ad extends com.baidu.adp.framework.c.a {
    final /* synthetic */ OfficialBarHistoryActivity a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        ai aiVar;
        List<bf> list2;
        List list3;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        this.a.hideProgressBar();
        if (customResponsedMessage2 != null && customResponsedMessage2.g() == 2001156 && (customResponsedMessage2 instanceof ResponseLocalHistoryMessage)) {
            ResponseLocalHistoryMessage responseLocalHistoryMessage = (ResponseLocalHistoryMessage) customResponsedMessage2;
            if (responseLocalHistoryMessage.a().isEmpty()) {
                return;
            }
            list = this.a.e;
            if (list != null) {
                list3 = this.a.e;
                if (!list3.isEmpty()) {
                    return;
                }
            }
            this.a.e = responseLocalHistoryMessage.a();
            aiVar = this.a.b;
            list2 = this.a.e;
            aiVar.a(list2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(2001156);
        this.a = officialBarHistoryActivity;
    }
}
