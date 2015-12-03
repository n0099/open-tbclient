package com.baidu.tieba.emotion.editortool;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.editortools.k)) {
            com.baidu.tbadk.editortools.k kVar = (com.baidu.tbadk.editortools.k) customResponsedMessage.getData();
            int indexOf = kVar.getCollectTools().indexOf(5);
            if (indexOf != -1) {
                kVar.b(new s(kVar.getContext(), indexOf + 1));
            }
        }
    }
}
