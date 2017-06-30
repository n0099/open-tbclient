package com.baidu.tieba.discover;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b bPL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.bPL = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        e eVar;
        String str2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
            String str3 = (String) customResponsedMessage.getData();
            str = this.bPL.mUrl;
            if (!str.contains(str3)) {
                str2 = this.bPL.mUrl;
                if (!str3.contains(str2)) {
                    return;
                }
            }
            eVar = this.bPL.bPK;
            eVar.Nm();
        }
    }
}
