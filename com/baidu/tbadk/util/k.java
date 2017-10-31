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
    private static String aMi;
    private static String aMj;
    private static String aMh = "";
    private static int mThreadType = 0;
    public static String aMk = "floor";
    public static String aMl = "pbPage";

    public static void a(String str, String str2, String str3, int i, com.baidu.adp.base.e eVar) {
        aMi = str;
        aMj = str2;
        aMh = str3;
        mThreadType = i;
        if (!StringUtils.isNull(aMh) && eVar != null && eVar.getPageActivity() != null) {
            if (aMk.equals(aMh)) {
                if (mThreadType == 33) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(eVar.getPageActivity()).createPhotoLiveCommentActivityConfig(aMi, aMj, true)));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(eVar.getPageActivity()).createSubPbActivityConfig(aMi, aMj, "search_post", true)));
            } else if (mThreadType == 33) {
                TiebaStatic.log("c10256");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(eVar.getPageActivity(), aMi).cx(aMj).cy("search_post").pi()));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(eVar.getPageActivity()).createNormalCfg(aMi, aMj, "search_post")));
            }
        }
    }
}
