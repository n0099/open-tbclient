package com.baidu.tieba.im.chat.notify;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        TextView textView;
        TextView textView2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001124 && (customResponsedMessage instanceof NewsNotifyMessage)) {
            int msgChat = ((NewsNotifyMessage) customResponsedMessage).getMsgChat();
            textView = ImMessageCenterDelegateStatic.Pi;
            if (textView != null) {
                textView2 = ImMessageCenterDelegateStatic.Pi;
                ImMessageCenterDelegateStatic.p(textView2, msgChat);
            }
        }
    }
}
