package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(n nVar, int i) {
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
        DataRes.Builder builder3;
        DataRes.Builder builder4;
        DataRes.Builder builder5;
        com.baidu.tieba.homepage.personalize.b.ab abVar;
        com.baidu.tieba.homepage.personalize.b.ab abVar2;
        List list3;
        DataRes.Builder builder6;
        DataRes.Builder builder7;
        DataRes.Builder builder8;
        List list4;
        List list5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
            builder = this.this$0.cqf;
            if (builder != null) {
                builder2 = this.this$0.cqf;
                if (com.baidu.tbadk.core.util.x.s(builder2.thread_list) != 0) {
                    list = this.this$0.aNw;
                    if (com.baidu.tbadk.core.util.x.s(list) != 0) {
                        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                        if (!StringUtils.isNull(optString)) {
                            list2 = this.this$0.aNw;
                            Iterator it = list2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) it.next();
                                if (vVar instanceof com.baidu.tieba.card.data.c) {
                                    com.baidu.tieba.card.data.c cVar = (com.baidu.tieba.card.data.c) vVar;
                                    if (cVar.IU() != null && cVar.IU().getTid() != null && cVar.IU().getTid().equals(optString)) {
                                        it.remove();
                                        list5 = this.this$0.aNw;
                                        com.baidu.tieba.homepage.personalize.c.c.bs(list5);
                                        break;
                                    }
                                }
                            }
                            builder3 = this.this$0.cqf;
                            if (builder3 != null) {
                                builder4 = this.this$0.cqf;
                                if (builder4.thread_list != null) {
                                    long c = com.baidu.adp.lib.h.b.c(optString, 0L);
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        builder5 = this.this$0.cqf;
                                        if (i2 < builder5.thread_list.size()) {
                                            builder6 = this.this$0.cqf;
                                            ThreadInfo threadInfo = builder6.thread_list.get(i2);
                                            if (threadInfo != null && threadInfo.tid != null && threadInfo.tid.longValue() == c) {
                                                builder7 = this.this$0.cqf;
                                                builder7.thread_list.remove(i2);
                                                this.this$0.ajf();
                                                long longValue = threadInfo.tid.longValue();
                                                builder8 = this.this$0.cqf;
                                                List<ThreadInfo> list6 = builder8.thread_list;
                                                list4 = this.this$0.aNw;
                                                com.baidu.tieba.homepage.personalize.d.f.a(longValue, i2, list6, list4);
                                                break;
                                            }
                                            i = i2 + 1;
                                        } else {
                                            break;
                                        }
                                    }
                                    abVar = this.this$0.cqk;
                                    if (abVar != null) {
                                        abVar2 = this.this$0.cqk;
                                        list3 = this.this$0.aNw;
                                        abVar2.bq(new ArrayList(list3));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
