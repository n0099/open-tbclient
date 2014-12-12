package com.baidu.tbadk.live;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.LiveChatRoomEventData;
import com.baidu.tbadk.coreExtra.message.LiveChatRoomEventResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ LiveGroupManager abA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(LiveGroupManager liveGroupManager, int i) {
        super(i);
        this.abA = liveGroupManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LiveChatRoomEventData parseFromEventContent;
        if (customResponsedMessage.getCmd() == 2001166 && (customResponsedMessage instanceof LiveChatRoomEventResponseMessage)) {
            LiveChatRoomEventResponseMessage liveChatRoomEventResponseMessage = (LiveChatRoomEventResponseMessage) customResponsedMessage;
            if (!liveChatRoomEventResponseMessage.hasError()) {
                String data = liveChatRoomEventResponseMessage.getData();
                if (!TextUtils.isEmpty(data) && (parseFromEventContent = LiveChatRoomEventData.parseFromEventContent(data)) != null && parseFromEventContent.mEventId != null) {
                    if ("309".equals(parseFromEventContent.mEventId) || "310".equals(parseFromEventContent.mEventId)) {
                        if (String.valueOf(parseFromEventContent.mGroupId).equals(this.abA.getCurrentGroupId())) {
                            this.abA.stopAnyRunning();
                            this.abA.notifyGroup();
                        }
                    } else if ("308".equals(parseFromEventContent.mEventId)) {
                        if (String.valueOf(parseFromEventContent.mGroupId).equals(this.abA.getCurrentGroupId())) {
                            this.abA.setPublisherPaused(true);
                        }
                    } else if ("318".equals(parseFromEventContent.mEventId) && String.valueOf(parseFromEventContent.mGroupId).equals(this.abA.getCurrentGroupId())) {
                        this.abA.setPublisherPaused(false);
                    }
                }
            }
        }
    }
}
