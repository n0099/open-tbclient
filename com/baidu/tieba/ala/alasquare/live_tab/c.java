package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes3.dex */
public class c {
    public static final void a(TbPageContext tbPageContext, String str, String str2) {
        bc.aWU().b(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + ETAG.ITEM_SEPARATOR + "livetype" + ETAG.EQUAL + str2});
    }

    public static void a(Context context, SdkLiveInfoData sdkLiveInfoData) {
        if (sdkLiveInfoData != null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = com.baidu.adp.lib.f.b.toLong(sdkLiveInfoData.liveId, 0L);
            alaLiveInfoCoreData.threadId = com.baidu.adp.lib.f.b.toLong(sdkLiveInfoData.tid, 0L);
            if (sdkLiveInfoData.liveAuthor != null) {
                alaLiveInfoCoreData.userName = sdkLiveInfoData.liveAuthor.name;
            }
            if (sdkLiveInfoData.liveInfo != null) {
                alaLiveInfoCoreData.sessionID = sdkLiveInfoData.liveInfo.sessionId;
                alaLiveInfoCoreData.liveType = sdkLiveInfoData.liveInfo.liveType;
                alaLiveInfoCoreData.screenDirection = sdkLiveInfoData.liveInfo.screenDirection;
                alaLiveInfoCoreData.hslUrl = sdkLiveInfoData.liveInfo.hlsUrl;
                alaLiveInfoCoreData.liveCover = sdkLiveInfoData.liveInfo.cover;
                alaLiveInfoCoreData.rtmpUrl = sdkLiveInfoData.liveInfo.rtmpUrl;
                alaLiveInfoCoreData.liveTitle = sdkLiveInfoData.title;
                alaLiveInfoCoreData.audienceCount = sdkLiveInfoData.liveInfo.audienceCount;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
        }
    }

    public static void a(Context context, bu buVar) {
        b(context, buVar, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MY_CONCERN);
    }

    private static void b(Context context, bu buVar, String str) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(context, context.getString(R.string.no_network_guide));
        } else if (context != null && buVar != null && buVar.aSp() != null && buVar.aSJ() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = buVar.aSp().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(buVar.aSJ());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, null, str, str2, z, null, null)));
        }
    }

    public static int[] ew(Context context) {
        int dimensionPixelSize = l.getScreenDimensions(context)[0] - (context.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        return new int[]{dimensionPixelSize, (int) ((dimensionPixelSize * 9.0d) / 16.0d)};
    }
}
