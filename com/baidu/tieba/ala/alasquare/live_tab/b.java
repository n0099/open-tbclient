package com.baidu.tieba.ala.alasquare.live_tab;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b {
    public static void a(Context context, bh bhVar) {
        a(context, bhVar, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN);
    }

    public static void b(Context context, bh bhVar) {
        a(context, bhVar, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MY_CONCERN);
    }

    private static void a(Context context, bh bhVar, String str) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(context, context.getString(R.string.no_network_guide));
        } else if (context != null && bhVar != null && bhVar.aiG() != null && bhVar.aiZ() != null) {
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bhVar.aiG().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiZ());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, null, str, str2, z, null, null)));
        }
    }

    public static int[] dj(Context context) {
        int dimensionPixelSize = l.getScreenDimensions(context)[0] - (context.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        return new int[]{dimensionPixelSize, (int) ((dimensionPixelSize * 9.0d) / 16.0d)};
    }
}
