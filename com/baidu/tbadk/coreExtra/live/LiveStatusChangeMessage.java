package com.baidu.tbadk.coreExtra.live;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class LiveStatusChangeMessage extends CustomResponsedMessage<LiveStatusData> {

    /* loaded from: classes.dex */
    public class LiveStatusData {
        public String errorString;
        public String groupId;
        public int status;
        public String url;
    }

    public LiveStatusChangeMessage(LiveStatusData liveStatusData) {
        super(2001161, liveStatusData);
    }

    public static boolean isPublishing(LiveStatusData liveStatusData) {
        if (liveStatusData == null || StringUtils.isNull(liveStatusData.groupId)) {
            return false;
        }
        return liveStatusData.status == 1 || liveStatusData.status == 3 || liveStatusData.status == 4;
    }

    public static boolean isPlayingLive(LiveStatusData liveStatusData) {
        if (liveStatusData == null || StringUtils.isNull(liveStatusData.groupId) || LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(liveStatusData.groupId)) {
            return false;
        }
        return liveStatusData.status == 18 || liveStatusData.status == 19 || liveStatusData.status == 20 || liveStatusData.status == 17;
    }

    public static boolean isPlayingRecord(LiveStatusData liveStatusData) {
        if (liveStatusData == null || StringUtils.isNull(liveStatusData.groupId) || !LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(liveStatusData.groupId)) {
            return false;
        }
        return liveStatusData.status == 18 || liveStatusData.status == 19 || liveStatusData.status == 20 || liveStatusData.status == 17;
    }
}
