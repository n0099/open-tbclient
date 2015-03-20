package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.chat.bc;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class ar extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bc)) {
            bc bcVar = (bc) customResponsedMessage.getData();
            if (bcVar.aXi != null && bcVar.context != null) {
                MsgMultiImageTextViewItemAdapter msgMultiImageTextViewItemAdapter = new MsgMultiImageTextViewItemAdapter(bcVar.context, ChatMessage.TYPE_MSG_MULTI_PIC_TEXT);
                msgMultiImageTextViewItemAdapter.cp(true);
                bcVar.aXi.add(msgMultiImageTextViewItemAdapter);
            }
        }
    }
}
