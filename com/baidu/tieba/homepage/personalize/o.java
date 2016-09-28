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
public class o extends CustomMessageListener {
    final /* synthetic */ m this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(m mVar, int i) {
        super(i);
        this.this$0 = mVar;
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
        list = this.this$0.aMf;
        if (list.size() > 0) {
            list2 = this.this$0.aMf;
            if (list2.get(0) instanceof com.baidu.tieba.homepage.personalize.data.j) {
                list5 = this.this$0.aMf;
                com.baidu.tieba.homepage.personalize.data.j jVar = (com.baidu.tieba.homepage.personalize.data.j) list5.get(0);
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                if (jVar.cHF != null) {
                    for (com.baidu.tieba.homepage.personalize.data.i iVar : jVar.cHF) {
                        if (iVar != null) {
                            TagStruct.Builder builder4 = new TagStruct.Builder();
                            builder4.tag_name = iVar.PC;
                            builder4.selected = Integer.valueOf(iVar.cHD ? 1 : 0);
                            linkedList.add(builder4.build(false));
                        }
                    }
                }
                if (jVar.cHG != null) {
                    for (com.baidu.tieba.homepage.personalize.data.i iVar2 : jVar.cHG) {
                        if (iVar2 != null) {
                            TagStruct.Builder builder5 = new TagStruct.Builder();
                            builder5.tag_name = iVar2.PC;
                            builder5.selected = Integer.valueOf(iVar2.cHD ? 1 : 0);
                            linkedList2.add(builder5.build(false));
                        }
                    }
                }
                builder2 = this.this$0.cFw;
                if (builder2 != null) {
                    AgeSexModule.Builder builder6 = new AgeSexModule.Builder();
                    builder6.sex_tag = linkedList;
                    builder6.age_tag = linkedList2;
                    builder3 = this.this$0.cFw;
                    builder3.age_sex = builder6.build(false);
                }
            } else {
                list3 = this.this$0.aMf;
                if (list3.get(0) instanceof com.baidu.tieba.homepage.personalize.data.h) {
                    list4 = this.this$0.aMf;
                    com.baidu.tieba.homepage.personalize.data.h hVar = (com.baidu.tieba.homepage.personalize.data.h) list4.get(0);
                    if (hVar.cHB != null) {
                        LinkedList linkedList3 = new LinkedList();
                        for (com.baidu.tieba.homepage.personalize.data.i iVar3 : hVar.cHB) {
                            if (iVar3 != null) {
                                TagStruct.Builder builder7 = new TagStruct.Builder();
                                builder7.tag_name = iVar3.PC;
                                builder7.selected = Integer.valueOf(iVar3.cHD ? 1 : 0);
                                linkedList3.add(builder7.build(false));
                            }
                        }
                        builder = this.this$0.cFw;
                        builder.interestion = linkedList3;
                    }
                }
            }
            this.this$0.amK();
        }
    }
}
