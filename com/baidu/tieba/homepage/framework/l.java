package com.baidu.tieba.homepage.framework;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ RecommendFrsControlFragment czI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
        super(i);
        this.czI = recommendFrsControlFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
            c.a aVar = (c.a) customResponsedMessage.getData();
            ArrayList<com.baidu.tieba.homepage.b.a.a> arrayList = new ArrayList();
            scrollFragmentTabHost = this.czI.czu;
            if (!x.r(scrollFragmentTabHost.getTagList())) {
                scrollFragmentTabHost2 = this.czI.czu;
                arrayList.addAll(scrollFragmentTabHost2.getTagList());
            }
            com.baidu.tieba.homepage.b.a.a aVar2 = new com.baidu.tieba.homepage.b.a.a();
            aVar2.cDr = aVar.forumName;
            aVar2.isSelected = false;
            aVar2.level = aVar.level;
            arrayList.add(aVar2);
            ArrayList arrayList2 = new ArrayList();
            for (com.baidu.tieba.homepage.b.a.a aVar3 : arrayList) {
                if (aVar3 != null && !StringUtils.isNull(aVar3.cDr) && aVar3.cDs != -1 && aVar3.cDs != -2) {
                    arrayList2.add(new c.a(aVar3.cDr, aVar3.level));
                }
            }
            com.baidu.tbadk.util.c.B(arrayList2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, true));
        }
    }
}
