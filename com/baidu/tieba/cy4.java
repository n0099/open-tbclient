package com.baidu.tieba;

import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LiveRemindData;
import java.util.List;
import tbclient.AlaLiveInfo;
/* loaded from: classes3.dex */
public interface cy4 {
    IconPopData getIconPopData();

    LevePopData getLevePopData();

    List<AlaLiveInfo> getLiveFollowSecondFloor();

    List<AlaLiveInfo> getLiveIndexSecondFloor();

    List<AlaLiveInfo> getLivePicSecondFloor();

    LiveRemindData getLiveRemindData();
}
