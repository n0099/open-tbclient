package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class k {
    private static String aMq;
    private static String aMr;
    private static String aMp = "";
    private static int mThreadType = 0;
    public static String aMs = "floor";
    public static String aMt = "pbPage";

    public static void a(String str, String str2, String str3, int i, com.baidu.adp.base.e eVar) {
        aMq = str;
        aMr = str2;
        aMp = str3;
        mThreadType = i;
        if (!StringUtils.isNull(aMp) && eVar != null && eVar.getPageActivity() != null) {
            if (aMs.equals(aMp)) {
                if (mThreadType == 33) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(eVar.getPageActivity()).createPhotoLiveCommentActivityConfig(aMq, aMr, true)));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(eVar.getPageActivity()).createSubPbActivityConfig(aMq, aMr, "search_post", true)));
            } else if (mThreadType == 33) {
                TiebaStatic.log("c10256");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(eVar.getPageActivity(), aMq).cx(aMr).cy("search_post").pi()));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(eVar.getPageActivity()).createNormalCfg(aMq, aMr, "search_post")));
            }
        }
    }
}
