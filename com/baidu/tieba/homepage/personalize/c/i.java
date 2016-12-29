package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ g csn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, int i) {
        super(i);
        this.csn = gVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        onMessage2((CustomResponsedMessage) customResponsedMessage);
    }

    /* renamed from: onMessage  reason: avoid collision after fix types in other method */
    public void onMessage2(CustomResponsedMessage customResponsedMessage) {
        String str;
        String str2;
        String str3;
        if (customResponsedMessage != null) {
            if (!(customResponsedMessage.getData() instanceof com.baidu.tieba.homepage.personalize.data.g)) {
                this.csn.csg = null;
                this.csn.csj = 0;
                return;
            }
            com.baidu.tieba.homepage.personalize.data.g gVar = (com.baidu.tieba.homepage.personalize.data.g) customResponsedMessage.getData();
            if (gVar.crV) {
                str2 = this.csn.csg;
                if (!StringUtils.isNull(str2)) {
                    str3 = this.csn.csg;
                    if (str3.equals(gVar.PR)) {
                        this.csn.csj = 2;
                        this.csn.csg = gVar.PR;
                        return;
                    }
                }
                this.csn.csj = 1;
                this.csn.csg = gVar.PR;
                return;
            }
            str = this.csn.csg;
            if (StringUtils.isNull(str)) {
                this.csn.csj = 2;
            } else {
                this.csn.csj = 1;
            }
            this.csn.csg = null;
        }
    }
}
