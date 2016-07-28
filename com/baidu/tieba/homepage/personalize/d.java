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
public class d extends CustomMessageListener {
    final /* synthetic */ b ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.ctz = bVar;
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
        list = this.ctz.aKa;
        if (list.size() > 0) {
            list2 = this.ctz.aKa;
            if (list2.get(0) instanceof com.baidu.tieba.homepage.personalize.data.j) {
                list5 = this.ctz.aKa;
                com.baidu.tieba.homepage.personalize.data.j jVar = (com.baidu.tieba.homepage.personalize.data.j) list5.get(0);
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                if (jVar.cvm != null) {
                    for (com.baidu.tieba.homepage.personalize.data.i iVar : jVar.cvm) {
                        if (iVar != null) {
                            TagStruct.Builder builder4 = new TagStruct.Builder();
                            builder4.tag_name = iVar.cvj;
                            builder4.selected = Integer.valueOf(iVar.cvk ? 1 : 0);
                            linkedList.add(builder4.build(false));
                        }
                    }
                }
                if (jVar.cvn != null) {
                    for (com.baidu.tieba.homepage.personalize.data.i iVar2 : jVar.cvn) {
                        if (iVar2 != null) {
                            TagStruct.Builder builder5 = new TagStruct.Builder();
                            builder5.tag_name = iVar2.cvj;
                            builder5.selected = Integer.valueOf(iVar2.cvk ? 1 : 0);
                            linkedList2.add(builder5.build(false));
                        }
                    }
                }
                builder2 = this.ctz.csT;
                if (builder2 != null) {
                    AgeSexModule.Builder builder6 = new AgeSexModule.Builder();
                    builder6.sex_tag = linkedList;
                    builder6.age_tag = linkedList2;
                    builder3 = this.ctz.csT;
                    builder3.age_sex = builder6.build(false);
                }
            } else {
                list3 = this.ctz.aKa;
                if (list3.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h) {
                    list4 = this.ctz.aKa;
                    com.baidu.tieba.homepage.personalize.data.h hVar = (com.baidu.tieba.homepage.personalize.data.h) list4.get(0);
                    if (hVar.cvh != null) {
                        LinkedList linkedList3 = new LinkedList();
                        for (com.baidu.tieba.homepage.personalize.data.i iVar3 : hVar.cvh) {
                            if (iVar3 != null) {
                                TagStruct.Builder builder7 = new TagStruct.Builder();
                                builder7.tag_name = iVar3.cvj;
                                builder7.selected = Integer.valueOf(iVar3.cvk ? 1 : 0);
                                linkedList3.add(builder7.build(false));
                            }
                        }
                        builder = this.ctz.csT;
                        builder.interestion = linkedList3;
                    }
                }
            }
            this.ctz.ahD();
        }
    }
}
