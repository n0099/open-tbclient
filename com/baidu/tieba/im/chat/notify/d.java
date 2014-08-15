package com.baidu.tieba.im.chat.notify;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        TextView textView;
        TextView textView2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001124 && (customResponsedMessage instanceof NewsNotifyMessage)) {
            int msgChat = ((NewsNotifyMessage) customResponsedMessage).getMsgChat();
            textView = ImMessageCenterDelegateStatic.c;
            if (textView != null) {
                textView2 = ImMessageCenterDelegateStatic.c;
                ImMessageCenterDelegateStatic.b(textView2, msgChat);
            }
        }
    }
}
