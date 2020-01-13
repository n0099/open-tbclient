package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
/* loaded from: classes.dex */
public class q {
    private static String OG;
    private static String mPid;
    private static String dCy = "";
    private static int mThreadType = 0;
    public static String dCz = "floor";
    public static String dCA = "pbPage";

    public static void a(String str, String str2, String str3, int i, com.baidu.adp.base.e eVar, BaijiahaoData baijiahaoData) {
        OG = str;
        mPid = str2;
        dCy = str3;
        mThreadType = i;
        if (!StringUtils.isNull(dCy) && eVar != null && eVar.getPageActivity() != null) {
            if (dCz.equals(dCy)) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(eVar.getPageActivity()).createSubPbActivityConfig(OG, mPid, "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                createSubPbActivityConfig.setBjhData(baijiahaoData);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(eVar.getPageActivity()).createNormalCfg(OG, mPid, "search_post");
            createNormalCfg.setStartFrom(8);
            createNormalCfg.setBjhData(baijiahaoData);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }
}
