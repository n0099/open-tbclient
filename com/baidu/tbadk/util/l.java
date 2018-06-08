package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
/* loaded from: classes.dex */
public class l {
    private static String aVt;
    private static String mPid;
    private static String aVs = "";
    private static int mThreadType = 0;
    public static String aVu = "floor";
    public static String aVv = "pbPage";

    public static void a(String str, String str2, String str3, int i, com.baidu.adp.base.e eVar) {
        aVt = str;
        mPid = str2;
        aVs = str3;
        mThreadType = i;
        if (!StringUtils.isNull(aVs) && eVar != null && eVar.getPageActivity() != null) {
            if (aVu.equals(aVs)) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(eVar.getPageActivity()).createSubPbActivityConfig(aVt, mPid, "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(eVar.getPageActivity()).createNormalCfg(aVt, mPid, "search_post");
            createNormalCfg.setStartFrom(8);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }
}
