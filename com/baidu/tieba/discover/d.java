package com.baidu.tieba.discover;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ b bDA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.bDA = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        f fVar;
        String str;
        f fVar2;
        String str2;
        String ig;
        if (customResponsedMessage != null) {
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                if (((Integer) data).intValue() == 1) {
                    fVar2 = this.bDA.bDx;
                    b bVar = this.bDA;
                    str2 = this.bDA.mUrl;
                    ig = bVar.ig(str2);
                    fVar2.loadUrl(ig);
                    return;
                }
                fVar = this.bDA.bDx;
                str = this.bDA.mUrl;
                fVar.loadUrl(str);
            }
        }
    }
}
