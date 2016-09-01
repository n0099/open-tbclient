package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends CustomMessageListener {
    final /* synthetic */ g cHg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g gVar, int i) {
        super(i);
        this.cHg = gVar;
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
                this.cHg.cHa = null;
                this.cHg.cHc = 0;
                return;
            }
            com.baidu.tieba.homepage.personalize.data.i iVar = (com.baidu.tieba.homepage.personalize.data.i) customResponsedMessage.getData();
            if (iVar.cGO) {
                str2 = this.cHg.cHa;
                if (!StringUtils.isNull(str2)) {
                    str3 = this.cHg.cHa;
                    if (str3.equals(iVar.PE)) {
                        this.cHg.cHc = 2;
                        this.cHg.cHa = iVar.PE;
                        return;
                    }
                }
                this.cHg.cHc = 1;
                this.cHg.cHa = iVar.PE;
                return;
            }
            str = this.cHg.cHa;
            if (StringUtils.isNull(str)) {
                this.cHg.cHc = 2;
            } else {
                this.cHg.cHc = 1;
            }
            this.cHg.cHa = null;
        }
    }
}
