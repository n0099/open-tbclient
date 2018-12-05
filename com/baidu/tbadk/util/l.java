package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
/* loaded from: classes.dex */
public class l {
    private static String biw;
    private static String mPid;
    private static String biv = "";
    private static int mThreadType = 0;
    public static String bix = "floor";
    public static String biy = "pbPage";

    public static void a(String str, String str2, String str3, int i, com.baidu.adp.base.e eVar) {
        biw = str;
        mPid = str2;
        biv = str3;
        mThreadType = i;
        if (!StringUtils.isNull(biv) && eVar != null && eVar.getPageActivity() != null) {
            if (bix.equals(biv)) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(eVar.getPageActivity()).createSubPbActivityConfig(biw, mPid, "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(eVar.getPageActivity()).createNormalCfg(biw, mPid, "search_post");
            createNormalCfg.setStartFrom(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }
}
