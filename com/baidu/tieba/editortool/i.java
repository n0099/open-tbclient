package com.baidu.tieba.editortool;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class i extends CustomMessageListener {
    final /* synthetic */ EditorInfoContainer aqs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(EditorInfoContainer editorInfoContainer, int i) {
        super(i);
        this.aqs = editorInfoContainer;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            Object data = customResponsedMessage.getData();
            if (data instanceof ba) {
                this.aqs.a((ba) data);
            }
        }
    }
}
