package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends CustomMessageListener {
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(n nVar, int i) {
        super(i);
        this.this$0 = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        DataRes.Builder builder2;
        List list;
        List list2;
        com.baidu.tieba.homepage.personalize.b.ad adVar;
        com.baidu.tieba.homepage.personalize.b.ad adVar2;
        List list3;
        if (customResponsedMessage != null) {
            builder = this.this$0.czv;
            if (builder != null) {
                builder2 = this.this$0.czv;
                if (com.baidu.tbadk.core.util.x.p(builder2.thread_list) != 0) {
                    list = this.this$0.aSD;
                    if (com.baidu.tbadk.core.util.x.p(list) != 0) {
                        String str = (String) customResponsedMessage.getData();
                        n nVar = this.this$0;
                        list2 = this.this$0.aSD;
                        nVar.f(str, list2);
                        this.this$0.jG(str);
                        adVar = this.this$0.czA;
                        if (adVar != null) {
                            adVar2 = this.this$0.czA;
                            list3 = this.this$0.aSD;
                            adVar2.bd(new ArrayList(list3));
                        }
                    }
                }
            }
        }
    }
}
