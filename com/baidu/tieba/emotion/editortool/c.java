package com.baidu.tieba.emotion.editortool;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
            for (com.baidu.tbadk.editortools.emotiontool.a aVar : (List) customResponsedMessage.getData()) {
                x.JL().b(aVar);
            }
            x.JL().JM();
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }
}
