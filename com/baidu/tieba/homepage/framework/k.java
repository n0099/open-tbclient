package com.baidu.tieba.homepage.framework;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ RecommendFrsControlFragment cHu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
        super(i);
        this.cHu = recommendFrsControlFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Object data;
        Integer num;
        boolean z;
        ScrollFragmentTabHost scrollFragmentTabHost;
        String str;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        if (customResponsedMessage != null && (data = customResponsedMessage.getData()) != null) {
            if (data instanceof Integer) {
                num = (Integer) data;
                z = false;
            } else if (data instanceof String) {
                String str2 = (String) data;
                scrollFragmentTabHost2 = this.cHu.cHg;
                List<com.baidu.tieba.homepage.b.a.a> tagList = scrollFragmentTabHost2.getTagList();
                int s = z.s(tagList);
                int i = 0;
                while (true) {
                    if (i >= s) {
                        num = -1;
                        z = false;
                        break;
                    } else if (!str2.equals(tagList.get(i).cLo)) {
                        i++;
                    } else {
                        num = Integer.valueOf(i);
                        z = true;
                        break;
                    }
                }
            } else if (!(data instanceof Boolean)) {
                num = -1;
                z = false;
            } else {
                ArrayList arrayList = new ArrayList();
                com.baidu.tieba.homepage.b.a.a aVar = new com.baidu.tieba.homepage.b.a.a();
                aVar.cLo = "推荐";
                aVar.cLp = -1L;
                aVar.isSelected = false;
                arrayList.add(aVar);
                com.baidu.tieba.homepage.b.a.a aVar2 = new com.baidu.tieba.homepage.b.a.a();
                aVar2.cLo = "发现";
                aVar2.cLp = -2L;
                aVar2.isSelected = false;
                arrayList.add(aVar2);
                c.a[] GC = com.baidu.tbadk.util.c.GC();
                scrollFragmentTabHost = this.cHu.cHg;
                com.baidu.tieba.homepage.b.a.a aVar3 = (com.baidu.tieba.homepage.b.a.a) z.c(scrollFragmentTabHost.getTagList(), com.baidu.tieba.homepage.framework.a.a.amr().cIi);
                if (aVar3 == null) {
                    str = null;
                } else {
                    str = aVar3.cLo;
                }
                int length = GC.length;
                Integer num2 = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    String str3 = GC[i2].forumName;
                    int i3 = GC[i2].level;
                    com.baidu.tieba.homepage.b.a.a aVar4 = new com.baidu.tieba.homepage.b.a.a();
                    aVar4.cLo = str3;
                    aVar4.isSelected = false;
                    aVar4.level = i3;
                    arrayList.add(aVar4);
                    if (str3.equals(str)) {
                        num2 = Integer.valueOf(i2 + 1);
                    }
                }
                if (!((Boolean) data).booleanValue() && num2.intValue() == -1) {
                    num2 = Integer.valueOf(com.baidu.tieba.homepage.framework.a.a.amr().cIi - 1);
                }
                this.cHu.aZ(arrayList);
                num = num2;
                z = false;
            }
            scrollFragmentTabHost3 = this.cHu.cHg;
            scrollFragmentTabHost3.g(num.intValue(), z);
        }
    }
}
