package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
/* loaded from: classes.dex */
public class o {
    private static String cmS;
    private static String mPid;
    private static String cPd = "";
    private static int mThreadType = 0;
    public static String cPe = "floor";
    public static String cPf = "pbPage";

    public static void a(String str, String str2, String str3, int i, com.baidu.adp.base.e eVar) {
        cmS = str;
        mPid = str2;
        cPd = str3;
        mThreadType = i;
        if (!StringUtils.isNull(cPd) && eVar != null && eVar.getPageActivity() != null) {
            if (cPe.equals(cPd)) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(eVar.getPageActivity()).createSubPbActivityConfig(cmS, mPid, "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(eVar.getPageActivity()).createNormalCfg(cmS, mPid, "search_post");
            createNormalCfg.setStartFrom(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }
}
