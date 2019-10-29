package com.baidu.tieba.ala.player;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
/* loaded from: classes6.dex */
public class a {
    public static String e(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData == null || alaLiveInfoData.session_info == null) {
            return null;
        }
        return alaLiveInfoData.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
    }
}
