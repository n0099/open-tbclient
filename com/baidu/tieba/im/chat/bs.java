package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.widget.richText.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends CustomMessageListener {
    final /* synthetic */ TalkableActivity cVS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(TalkableActivity talkableActivity, int i) {
        super(i);
        this.cVS = talkableActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof h.a)) {
            h.a aVar = (h.a) customResponsedMessage.getData();
            com.baidu.tbadk.widget.richText.h.a(this.cVS.getPageContext(), aVar.type, aVar.url, aVar.subType);
        }
    }
}
