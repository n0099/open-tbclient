package com.baidu.tieba.homepage.framework;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends CustomMessageListener {
    final /* synthetic */ RecommendFrsControlFragment cHu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
        super(i);
        this.cHu = recommendFrsControlFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Object data;
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        int i;
        boolean z;
        String str = null;
        if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null) {
            String str2 = data instanceof String ? (String) data : null;
            if (!StringUtils.isNull(str2)) {
                ArrayList<com.baidu.tieba.homepage.b.a.a> arrayList = new ArrayList();
                scrollFragmentTabHost = this.cHu.cHg;
                if (!z.t(scrollFragmentTabHost.getTagList())) {
                    scrollFragmentTabHost2 = this.cHu.cHg;
                    arrayList.addAll(scrollFragmentTabHost2.getTagList());
                    int i2 = com.baidu.tieba.homepage.framework.a.a.amr().cIi;
                    int size = arrayList.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            i = i2;
                            z = false;
                            break;
                        }
                        com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) arrayList.get(i3);
                        String str3 = aVar != null ? aVar.cLo : str;
                        if (!str2.equals(str3)) {
                            i3++;
                            str = str3;
                        } else {
                            z = true;
                            i = i3;
                            break;
                        }
                    }
                    if (z) {
                        arrayList.remove(i);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (com.baidu.tieba.homepage.b.a.a aVar2 : arrayList) {
                        if (aVar2 != null && !StringUtils.isNull(aVar2.cLo) && aVar2.cLp != -1 && aVar2.cLp != -2) {
                            arrayList2.add(new c.a(aVar2.cLo, aVar2.level));
                        }
                    }
                    com.baidu.tbadk.util.c.D(arrayList2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, false));
                }
            }
        }
    }
}
