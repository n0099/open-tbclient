package com.baidu.tieba.im.live;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.data.LiveChatRoomEventData;
import com.baidu.tbadk.coreExtra.message.LiveChatRoomEventResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b bVar, int i) {
        super(i);
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LiveChatRoomEventData parseFromEventContent;
        if (customResponsedMessage.getCmd() == 2003166 && (customResponsedMessage instanceof LiveChatRoomEventResponseMessage)) {
            LiveChatRoomEventResponseMessage liveChatRoomEventResponseMessage = (LiveChatRoomEventResponseMessage) customResponsedMessage;
            if (!liveChatRoomEventResponseMessage.hasError()) {
                String data = liveChatRoomEventResponseMessage.getData();
                if (!TextUtils.isEmpty(data) && (parseFromEventContent = LiveChatRoomEventData.parseFromEventContent(data)) != null && parseFromEventContent.mEventId != null) {
                    if ("309".equals(parseFromEventContent.mEventId) || "310".equals(parseFromEventContent.mEventId)) {
                        if (String.valueOf(parseFromEventContent.mGroupId).equals(this.a.i())) {
                            BdLog.d("EVENT_ID_GROUP_END or EVENT_ID_DISMISS_GROUP");
                            this.a.s();
                        }
                    } else if ("308".equals(parseFromEventContent.mEventId)) {
                        if (String.valueOf(parseFromEventContent.mGroupId).equals(this.a.i())) {
                            this.a.a(true);
                        }
                    } else if ("318".equals(parseFromEventContent.mEventId) && String.valueOf(parseFromEventContent.mGroupId).equals(this.a.i())) {
                        this.a.a(false);
                    }
                }
            }
        }
    }
}
