package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.coreExtra.live.LivePublisherSayMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends CustomMessageListener {
    final /* synthetic */ LiveMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(LiveMsglistModel liveMsglistModel, int i) {
        super(i);
        this.a = liveMsglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() == 2013007) {
                List<ChatMessage> a = this.a.a((ResponsedMessage<?>) customResponsedMessage);
                if (a != null) {
                    a(a);
                }
            } else if (customResponsedMessage.getCmd() == 2001146) {
                this.a.b(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2001149) {
                this.a.a(customResponsedMessage);
            }
        }
    }

    private void a(List<ChatMessage> list) {
        if (list != null && !TextUtils.isEmpty(this.a.o)) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ChatMessage chatMessage = list.get(size);
                if (this.a.o.equals(chatMessage.getUserInfo().getUserId())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new LivePublisherSayMessage(chatMessage));
                    return;
                }
            }
        }
    }
}
