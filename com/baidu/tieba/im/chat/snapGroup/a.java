package com.baidu.tieba.im.chat.snapGroup;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ChatRoomEventResponseMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SnapGroupChatActivity snapGroupChatActivity, int i) {
        super(i);
        this.a = snapGroupChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.data.b a;
        if (customResponsedMessage instanceof ChatRoomEventResponseMessage) {
            String data = ((ChatRoomEventResponseMessage) customResponsedMessage).getData();
            if (!TextUtils.isEmpty(data) && (a = com.baidu.tieba.im.data.b.a(data)) != null) {
                switch (a.h) {
                    case 202:
                        this.a.a(a);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
