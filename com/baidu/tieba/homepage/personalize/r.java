package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bl;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.Zan;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CustomMessageListener {
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(o oVar, int i) {
        super(i);
        this.this$0 = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        DataRes.Builder builder2;
        bl blVar;
        DataRes.Builder builder3;
        DataRes.Builder builder4;
        DataRes.Builder builder5;
        DataRes.Builder builder6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bl)) {
            builder = this.this$0.cAY;
            if (builder != null) {
                builder2 = this.this$0.cAY;
                if (com.baidu.tbadk.core.util.x.q(builder2.thread_list) != 0 && (blVar = (bl) customResponsedMessage.getData()) != null && blVar.rk() != null && blVar.getId() != null) {
                    builder3 = this.this$0.cAY;
                    if (com.baidu.tbadk.core.util.x.q(builder3.thread_list) != 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            builder4 = this.this$0.cAY;
                            if (i2 < builder4.thread_list.size()) {
                                builder5 = this.this$0.cAY;
                                ThreadInfo threadInfo = builder5.thread_list.get(i2);
                                if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.g.b.c(blVar.getId(), -1L)) {
                                    i = i2 + 1;
                                } else {
                                    ThreadInfo.Builder builder7 = new ThreadInfo.Builder(threadInfo);
                                    Zan.Builder builder8 = new Zan.Builder(builder7.zan);
                                    builder8.num = Integer.valueOf((int) blVar.rk().getNum());
                                    builder7.zan = builder8.build(true);
                                    builder6 = this.this$0.cAY;
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
