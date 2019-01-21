package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes3.dex */
public class OfficialMsglistAdapterStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001275) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialMsglistAdapterStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MsgAdapterScanMessage.a)) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.eLz != null && aVar.context != null) {
                        MsgMultiImageTextViewItemAdapter msgMultiImageTextViewItemAdapter = new MsgMultiImageTextViewItemAdapter(aVar.context, ChatMessage.TYPE_MSG_MULTI_PIC_TEXT);
                        msgMultiImageTextViewItemAdapter.m20if(true);
                        aVar.eLz.add(msgMultiImageTextViewItemAdapter);
                    }
                }
            }
        });
    }
}
