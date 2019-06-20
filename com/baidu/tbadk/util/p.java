package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
/* loaded from: classes.dex */
public class p {
    private static String bVM;
    private static String mPid;
    private static String cBH = "";
    private static int mThreadType = 0;
    public static String cBI = "floor";
    public static String cBJ = "pbPage";

    public static void a(String str, String str2, String str3, int i, com.baidu.adp.base.e eVar) {
        bVM = str;
        mPid = str2;
        cBH = str3;
        mThreadType = i;
        if (!StringUtils.isNull(cBH) && eVar != null && eVar.getPageActivity() != null) {
            if (cBI.equals(cBH)) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(eVar.getPageActivity()).createSubPbActivityConfig(bVM, mPid, "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(eVar.getPageActivity()).createNormalCfg(bVM, mPid, "search_post");
            createNormalCfg.setStartFrom(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }
}
