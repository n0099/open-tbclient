package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bj;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.Zan;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends CustomMessageListener {
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(n nVar, int i) {
        super(i);
        this.this$0 = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        DataRes.Builder builder2;
        bj bjVar;
        DataRes.Builder builder3;
        DataRes.Builder builder4;
        DataRes.Builder builder5;
        DataRes.Builder builder6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bj)) {
            builder = this.this$0.cyE;
            if (builder != null) {
                builder2 = this.this$0.cyE;
                if (com.baidu.tbadk.core.util.x.p(builder2.thread_list) != 0 && (bjVar = (bj) customResponsedMessage.getData()) != null && bjVar.rG() != null && bjVar.getId() != null) {
                    builder3 = this.this$0.cyE;
                    if (com.baidu.tbadk.core.util.x.p(builder3.thread_list) != 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            builder4 = this.this$0.cyE;
                            if (i2 < builder4.thread_list.size()) {
                                builder5 = this.this$0.cyE;
                                ThreadInfo threadInfo = builder5.thread_list.get(i2);
                                if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(bjVar.getId(), -1L)) {
                                    i = i2 + 1;
                                } else {
                                    ThreadInfo.Builder builder7 = new ThreadInfo.Builder(threadInfo);
                                    Zan.Builder builder8 = new Zan.Builder(builder7.zan);
                                    builder8.num = Integer.valueOf((int) bjVar.rG().getNum());
                                    builder7.zan = builder8.build(true);
                                    builder6 = this.this$0.cyE;
                                    builder6.thread_list.set(i2, builder7.build(true));
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
