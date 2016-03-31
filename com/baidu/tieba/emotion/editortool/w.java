package com.baidu.tieba.emotion.editortool;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public w(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
            ((List) customResponsedMessage.getData()).add(v.Nm());
        }
    }
}
