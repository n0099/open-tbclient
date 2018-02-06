package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class k {
    private static String bDf;
    private static String bDg;
    private static String bDe = "";
    private static int mThreadType = 0;
    public static String bDh = "floor";
    public static String bDi = "pbPage";

    public static void a(String str, String str2, String str3, int i, com.baidu.adp.base.e eVar) {
        bDf = str;
        bDg = str2;
        bDe = str3;
        mThreadType = i;
        if (!StringUtils.isNull(bDe) && eVar != null && eVar.getPageActivity() != null) {
            if (bDh.equals(bDe)) {
                if (mThreadType == 33) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveCommentActivityConfig(eVar.getPageActivity()).createPhotoLiveCommentActivityConfig(bDf, bDg, true)));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(eVar.getPageActivity()).createSubPbActivityConfig(bDf, bDg, "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            } else if (mThreadType == 33) {
                TiebaStatic.log("c10256");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(eVar.getPageActivity(), bDf).cP(bDg).cQ("search_post").xD()));
            } else {
                PbActivityConfig createNormalCfg = new PbActivityConfig(eVar.getPageActivity()).createNormalCfg(bDf, bDg, "search_post");
                createNormalCfg.setStartFrom(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            }
        }
    }
}
