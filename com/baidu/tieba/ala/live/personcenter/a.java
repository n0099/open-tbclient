package com.baidu.tieba.ala.live.personcenter;

import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.mapapi.UIMsg;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a {
    public static final int[] fpJ = {0, 1, UIMsg.f_FUN.FUN_ID_NET_OPTION, 4201, 10801, 22801, 42001, 70201, 109201, 160801, 226801, CmdConfigSocket.CMD_DRESSUP_CENTER, 409201, 529201, 670801, 835801, 1026001, 1243201, 1396901, 1612081, 1919481, 2349841, 2933901, 3702401, 4686081, 5915681, 7421941, 9235601, 11387401, 13908081, 16828381, 20179041, 23990801, 28294401, 33120581, 38500081, 44463641, 51042001, 58265901, 66166081};
    public static final int[] fpK = {0, FeatureCodes.FACE, 4200, ARPMessageType.ARPLuaSdkBridgeMessageType.MSG_TYPE_WEBVIEW_OPERATION, 22800, 42000, 70200, 109200, 160800, 226800, 309000, 409200, 529200, 670800, 835800, 1026000, 1243200, 1396900, 1612080, 1919480, 2349840, 2933900, 3702400, 4686080, 5915680, 7421940, 9235600, 11387400, 13908080, 16828380, 20179040, 23990800, 28294400, 33120580, 38500080, 44463640, 51042000, 58265900, 66166080, 74773280};

    public static final String pR(int i) {
        if (i == 0) {
            return String.valueOf(fpJ[i]);
        }
        return fpJ[i] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + fpK[i];
    }
}
