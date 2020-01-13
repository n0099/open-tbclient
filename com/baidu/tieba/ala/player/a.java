package com.baidu.tieba.ala.player;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static String e(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData == null || alaLiveInfoData.session_info == null) {
            return null;
        }
        String flvUrl = alaLiveInfoData.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
        return TextUtils.isEmpty(flvUrl) ? alaLiveInfoData.session_info.getRtmpUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT) : flvUrl;
    }

    public static String zs(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 1) {
            String str2 = pathSegments.get(pathSegments.size() - 1);
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split("\\.");
                if (split.length > 0) {
                    return split[0];
                }
            }
        }
        return null;
    }

    public static boolean cQ(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        String zs = zs(str);
        String zs2 = zs(str2);
        if (zs == null || zs2 == null) {
            return str.equals(str2);
        }
        return zs.equals(zs2);
    }
}
