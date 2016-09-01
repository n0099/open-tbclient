package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bi;
/* loaded from: classes.dex */
class aa implements bi.a {
    @Override // com.baidu.tbadk.core.util.bi.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        String gF;
        if (strArr == null || strArr.length == 0) {
            return 3;
        }
        String str = strArr[0];
        if (str.startsWith(TbConfig.URL_JUMP_TAG_WALLET)) {
            gF = TiebaStatic.gF(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, gF));
            if (tbPageContext.getOrignalPage() instanceof BaseWebViewActivity) {
                ((BaseWebViewActivity) tbPageContext.getOrignalPage()).finish();
            }
            return 0;
        }
        return 3;
    }
}
