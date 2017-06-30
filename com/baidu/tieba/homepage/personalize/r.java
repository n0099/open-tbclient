package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CustomMessageListener {
    final /* synthetic */ i cIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(i iVar, int i) {
        super(i);
        this.cIQ = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                this.cIQ.ccO = true;
            }
        }
    }
}
