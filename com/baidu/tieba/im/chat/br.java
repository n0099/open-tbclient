package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.widget.richText.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends CustomMessageListener {
    final /* synthetic */ TalkableActivity bLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(TalkableActivity talkableActivity, int i) {
        super(i);
        this.bLV = talkableActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof g.a)) {
            g.a aVar = (g.a) customResponsedMessage.getData();
            com.baidu.tbadk.widget.richText.g.a(this.bLV.getPageContext(), aVar.type, aVar.url, aVar.subType);
        }
    }
}
