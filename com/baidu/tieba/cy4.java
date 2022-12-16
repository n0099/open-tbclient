package com.baidu.tieba;

import com.baidu.tbadk.data.ChatRoomEntranceData;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LiveRemindData;
import com.baidu.tbadk.data.SubscribeGroupUnreadMsgData;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes4.dex */
public interface cy4 {
    ChatRoomEntranceData getChatRoomEntranceData();

    IconPopData getIconPopData();

    LevePopData getLevePopData();

    List<AlaLiveInfo> getLiveFollowSecondFloor();

    List<AlaLiveInfo> getLiveIndexSecondFloor();

    List<AlaLiveInfo> getLivePicSecondFloor();

    LiveRemindData getLiveRemindData();

    SubscribeGroupUnreadMsgData getSubscribeChatHaveUnReadMsg();

    String getUniqueId();
}
