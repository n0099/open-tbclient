package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ x this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(x xVar, int i) {
        super(i);
        this.this$0 = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        DataRes.Builder builder2;
        List list;
        List list2;
        com.baidu.tieba.homepage.personalize.b.af afVar;
        com.baidu.tieba.homepage.personalize.b.af afVar2;
        List list3;
        if (customResponsedMessage != null) {
            builder = this.this$0.cIV;
            if (builder != null) {
                builder2 = this.this$0.cIV;
                if (com.baidu.tbadk.core.util.z.s(builder2.thread_list) != 0) {
                    list = this.this$0.mDataList;
                    if (com.baidu.tbadk.core.util.z.s(list) != 0) {
                        String str = (String) customResponsedMessage.getData();
                        x xVar = this.this$0;
                        list2 = this.this$0.mDataList;
                        xVar.f(str, list2);
                        this.this$0.kU(str);
                        afVar = this.this$0.cIz;
                        if (afVar != null) {
                            afVar2 = this.this$0.cIz;
                            list3 = this.this$0.mDataList;
                            afVar2.bg(new ArrayList(list3));
                        }
                    }
                }
            }
        }
    }
}
