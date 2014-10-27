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
    final /* synthetic */ LivePlayingStatusMgr OJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(LivePlayingStatusMgr livePlayingStatusMgr, int i) {
        super(i);
        this.OJ = livePlayingStatusMgr;
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
                    i4 = this.OJ.gid;
                    if (i4 != 0) {
                        this.OJ.qg();
                    }
                } else if ("307".equals(parseFromEventContent.mEventId)) {
                    this.OJ.a(parseFromEventContent.mGroupId, LivePlayingStatusMgr.LivePlayingStatus.PLAYING);
                } else if ("318".equals(parseFromEventContent.mEventId)) {
                    i3 = this.OJ.gid;
                    if (i3 != 0) {
                        this.OJ.a(parseFromEventContent.mGroupId, LivePlayingStatusMgr.LivePlayingStatus.PLAYING);
                    }
                } else if ("308".equals(parseFromEventContent.mEventId)) {
                    i2 = this.OJ.gid;
                    if (i2 != 0) {
                        this.OJ.a(parseFromEventContent.mGroupId, LivePlayingStatusMgr.LivePlayingStatus.PAUSE);
                    }
                } else if ("309".equals(parseFromEventContent.mEventId)) {
                    i = this.OJ.gid;
                    if (i != 0) {
                        this.OJ.a(parseFromEventContent.mGroupId, LivePlayingStatusMgr.LivePlayingStatus.NO_PUBLISHER);
                    }
                }
            }
        }
    }
}
