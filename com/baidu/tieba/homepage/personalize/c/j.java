package com.baidu.tieba.homepage.personalize.c;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends CustomMessageListener {
    final /* synthetic */ g cHV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g gVar, int i) {
        super(i);
        this.cHV = gVar;
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
                this.cHV.cHP = null;
                this.cHV.cHR = 0;
                return;
            }
            com.baidu.tieba.homepage.personalize.data.i iVar = (com.baidu.tieba.homepage.personalize.data.i) customResponsedMessage.getData();
            if (iVar.cHD) {
                str2 = this.cHV.cHP;
                if (!StringUtils.isNull(str2)) {
                    str3 = this.cHV.cHP;
                    if (str3.equals(iVar.PC)) {
                        this.cHV.cHR = 2;
                        this.cHV.cHP = iVar.PC;
                        return;
                    }
                }
                this.cHV.cHR = 1;
                this.cHV.cHP = iVar.PC;
                return;
            }
            str = this.cHV.cHP;
            if (StringUtils.isNull(str)) {
                this.cHV.cHR = 2;
            } else {
                this.cHV.cHR = 1;
            }
            this.cHV.cHP = null;
        }
    }
}
