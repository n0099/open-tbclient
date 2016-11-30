package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ g cNi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, int i) {
        super(i);
        this.cNi = gVar;
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
            if (!(customResponsedMessage.getData() instanceof com.baidu.tieba.homepage.personalize.data.i)) {
                this.cNi.cNb = null;
                this.cNi.cNe = 0;
                return;
            }
            com.baidu.tieba.homepage.personalize.data.i iVar = (com.baidu.tieba.homepage.personalize.data.i) customResponsedMessage.getData();
            if (iVar.cMQ) {
                str2 = this.cNi.cNb;
                if (!StringUtils.isNull(str2)) {
                    str3 = this.cNi.cNb;
                    if (str3.equals(iVar.PW)) {
                        this.cNi.cNe = 2;
                        this.cNi.cNb = iVar.PW;
                        return;
                    }
                }
                this.cNi.cNe = 1;
                this.cNi.cNb = iVar.PW;
                return;
            }
            str = this.cNi.cNb;
            if (StringUtils.isNull(str)) {
                this.cNi.cNe = 2;
            } else {
                this.cNi.cNe = 1;
            }
            this.cNi.cNb = null;
        }
    }
}
