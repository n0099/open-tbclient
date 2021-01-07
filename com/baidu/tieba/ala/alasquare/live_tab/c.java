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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes10.dex */
public class c {
    public static final void a(TbPageContext tbPageContext, String str, String str2) {
        be.bwv().b(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + ETAG.ITEM_SEPARATOR + "livetype=" + str2});
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

    public static void a(TbPageContext tbPageContext, SdkLiveInfoData sdkLiveInfoData, String str) {
        if (tbPageContext != null && sdkLiveInfoData != null) {
            be.bwv().b(tbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + sdkLiveInfoData.roomId + "&live_id=" + sdkLiveInfoData.liveId + "&enterroom_type=1&from=" + str});
        }
    }

    public static void a(Context context, bz bzVar) {
        b(context, bzVar, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MY_CONCERN);
    }

    private static void b(Context context, bz bzVar, String str) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(context, context.getString(R.string.no_network_guide));
        } else if (context != null && bzVar != null && bzVar.brr() != null && bzVar.brK() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.brr().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.brK());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, null, str, str2, z, null, null)));
        }
    }

    public static int[] fX(Context context) {
        int dimensionPixelSize = l.getScreenDimensions(context)[0] - (context.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        return new int[]{dimensionPixelSize, (int) ((dimensionPixelSize * 9.0d) / 16.0d)};
    }

    public static boolean a(SdkLiveInfoData sdkLiveInfoData) {
        return (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null || at.isEmpty(sdkLiveInfoData.liveId) || at.isEmpty(sdkLiveInfoData.roomId) || !at.equals(sdkLiveInfoData.source, "jiaoyoufang") || sdkLiveInfoData.liveInfo.roomStatus != 2) ? false : true;
    }
}
