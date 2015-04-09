package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.LiveChatRoomEventData;
import com.baidu.tbadk.coreExtra.message.LiveChatRoomEventResponseMessage;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends CustomMessageListener {
    final /* synthetic */ LivePlayingStatusMgr afr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(LivePlayingStatusMgr livePlayingStatusMgr, int i) {
        super(i);
        this.afr = livePlayingStatusMgr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LiveChatRoomEventData parseFromEventContent;
        int i;
        int i2;
        int i3;
        int i4;
        if (customResponsedMessage.getCmd() == 2001166 && (customResponsedMessage instanceof LiveChatRoomEventResponseMessage)) {
            String data = ((LiveChatRoomEventResponseMessage) customResponsedMessage).getData();
            if (!TextUtils.isEmpty(data) && (parseFromEventContent = LiveChatRoomEventData.parseFromEventContent(data)) != null && !"302".equals(parseFromEventContent.mEventId) && !"306".equals(parseFromEventContent.mEventId)) {
                if ("310".equals(parseFromEventContent.mEventId)) {
                    i4 = this.afr.gid;
                    if (i4 != 0) {
                        this.afr.xl();
                    }
                } else if ("307".equals(parseFromEventContent.mEventId)) {
                    this.afr.a(parseFromEventContent.mGroupId, LivePlayingStatusMgr.LivePlayingStatus.PLAYING);
                } else if ("318".equals(parseFromEventContent.mEventId)) {
                    i3 = this.afr.gid;
                    if (i3 != 0) {
                        this.afr.a(parseFromEventContent.mGroupId, LivePlayingStatusMgr.LivePlayingStatus.PLAYING);
                    }
                } else if ("308".equals(parseFromEventContent.mEventId)) {
                    i2 = this.afr.gid;
                    if (i2 != 0) {
                        this.afr.a(parseFromEventContent.mGroupId, LivePlayingStatusMgr.LivePlayingStatus.PAUSE);
                    }
                } else if ("309".equals(parseFromEventContent.mEventId)) {
                    i = this.afr.gid;
                    if (i != 0) {
                        this.afr.a(parseFromEventContent.mGroupId, LivePlayingStatusMgr.LivePlayingStatus.NO_PUBLISHER);
                    }
                }
            }
        }
    }
}
