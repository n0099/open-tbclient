package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends CustomMessageListener {
    final /* synthetic */ g cvC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g gVar, int i) {
        super(i);
        this.cvC = gVar;
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
                this.cvC.cvw = null;
                this.cvC.cvy = 0;
                return;
            }
            com.baidu.tieba.homepage.personalize.data.i iVar = (com.baidu.tieba.homepage.personalize.data.i) customResponsedMessage.getData();
            if (iVar.cvk) {
                str2 = this.cvC.cvw;
                if (!StringUtils.isNull(str2)) {
                    str3 = this.cvC.cvw;
                    if (str3.equals(iVar.cvj)) {
                        this.cvC.cvy = 2;
                        this.cvC.cvw = iVar.cvj;
                        return;
                    }
                }
                this.cvC.cvy = 1;
                this.cvC.cvw = iVar.cvj;
                return;
            }
            str = this.cvC.cvw;
            if (StringUtils.isNull(str)) {
                this.cvC.cvy = 2;
            } else {
                this.cvC.cvy = 1;
            }
            this.cvC.cvw = null;
        }
    }
}
