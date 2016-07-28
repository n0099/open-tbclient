package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.be;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.Zan;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ b ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b bVar, int i) {
        super(i);
        this.ctz = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        DataRes.Builder builder2;
        be beVar;
        DataRes.Builder builder3;
        DataRes.Builder builder4;
        DataRes.Builder builder5;
        DataRes.Builder builder6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof be)) {
            builder = this.ctz.csT;
            if (builder != null) {
                builder2 = this.ctz.csT;
                if (com.baidu.tbadk.core.util.y.s(builder2.thread_list) != 0 && (beVar = (be) customResponsedMessage.getData()) != null && beVar.qp() != null && beVar.getId() != null) {
                    builder3 = this.ctz.csT;
                    if (com.baidu.tbadk.core.util.y.s(builder3.thread_list) != 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            builder4 = this.ctz.csT;
                            if (i2 < builder4.thread_list.size()) {
                                builder5 = this.ctz.csT;
                                ThreadInfo threadInfo = builder5.thread_list.get(i2);
                                if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.h.b.c(beVar.getId(), -1L)) {
                                    i = i2 + 1;
                                } else {
                                    ThreadInfo.Builder builder7 = new ThreadInfo.Builder(threadInfo);
                                    Zan.Builder builder8 = new Zan.Builder(builder7.zan);
                                    builder8.num = Integer.valueOf((int) beVar.qp().getNum());
                                    builder7.zan = builder8.build(true);
                                    builder6 = this.ctz.csT;
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
