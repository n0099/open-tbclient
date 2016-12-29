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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.editortools.j)) {
            com.baidu.tbadk.editortools.j jVar = (com.baidu.tbadk.editortools.j) customResponsedMessage.getData();
            int indexOf = jVar.getCollectTools().indexOf(5);
            if (indexOf != -1) {
                jVar.b(new s(jVar.getContext(), indexOf + 1));
            }
        }
    }
}
