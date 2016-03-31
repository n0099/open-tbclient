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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.editortools.l)) {
            com.baidu.tbadk.editortools.l lVar = (com.baidu.tbadk.editortools.l) customResponsedMessage.getData();
            int indexOf = lVar.getCollectTools().indexOf(5);
            if (indexOf != -1) {
                lVar.b(new s(lVar.getContext(), indexOf + 1));
            }
        }
    }
}
