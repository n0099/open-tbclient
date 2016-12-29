package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.AgeSexModule;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagStruct;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends CustomMessageListener {
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(n nVar, int i) {
        super(i);
        this.this$0 = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        List list2;
        List list3;
        List list4;
        DataRes.Builder builder;
        List list5;
        DataRes.Builder builder2;
        DataRes.Builder builder3;
        list = this.this$0.aNw;
        if (list.size() > 0) {
            list2 = this.this$0.aNw;
            if (list2.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h) {
                list5 = this.this$0.aNw;
                com.baidu.tieba.homepage.personalize.data.h hVar = (com.baidu.tieba.homepage.personalize.data.h) list5.get(0);
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                if (hVar.crX != null) {
                    for (com.baidu.tieba.homepage.personalize.data.g gVar : hVar.crX) {
                        if (gVar != null) {
                            TagStruct.Builder builder4 = new TagStruct.Builder();
                            builder4.tag_name = gVar.PR;
                            builder4.selected = Integer.valueOf(gVar.crV ? 1 : 0);
                            linkedList.add(builder4.build(false));
                        }
                    }
                }
                if (hVar.crY != null) {
                    for (com.baidu.tieba.homepage.personalize.data.g gVar2 : hVar.crY) {
                        if (gVar2 != null) {
                            TagStruct.Builder builder5 = new TagStruct.Builder();
                            builder5.tag_name = gVar2.PR;
                            builder5.selected = Integer.valueOf(gVar2.crV ? 1 : 0);
                            linkedList2.add(builder5.build(false));
                        }
                    }
                }
                builder2 = this.this$0.cqf;
                if (builder2 != null) {
                    AgeSexModule.Builder builder6 = new AgeSexModule.Builder();
                    builder6.sex_tag = linkedList;
                    builder6.age_tag = linkedList2;
                    builder3 = this.this$0.cqf;
                    builder3.age_sex = builder6.build(false);
                }
            } else {
                list3 = this.this$0.aNw;
                if (list3.get(0) instanceof com.baidu.tieba.homepage.personalize.data.f) {
                    list4 = this.this$0.aNw;
                    com.baidu.tieba.homepage.personalize.data.f fVar = (com.baidu.tieba.homepage.personalize.data.f) list4.get(0);
                    if (fVar.crT != null) {
                        LinkedList linkedList3 = new LinkedList();
                        for (com.baidu.tieba.homepage.personalize.data.g gVar3 : fVar.crT) {
                            if (gVar3 != null) {
                                TagStruct.Builder builder7 = new TagStruct.Builder();
                                builder7.tag_name = gVar3.PR;
                                builder7.selected = Integer.valueOf(gVar3.crV ? 1 : 0);
                                linkedList3.add(builder7.build(false));
                            }
                        }
                        builder = this.this$0.cqf;
                        builder.interestion = linkedList3;
                    }
                }
            }
            this.this$0.ajf();
        }
    }
}
