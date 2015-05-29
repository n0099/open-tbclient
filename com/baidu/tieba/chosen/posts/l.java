package com.baidu.tieba.chosen.posts;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.bk;
/* loaded from: classes.dex */
class l implements bk {
    @Override // com.baidu.tbadk.core.util.bk
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return false;
        }
        String str = strArr[0];
        if (str.startsWith("http://tieba.baidu.com/mo/q/recommendpb") && str.contains("ftid=")) {
            String substring = str.substring(str.lastIndexOf("ftid=") + "ftid=".length());
            if (tbPageContext != null) {
                tbPageContext.sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(tbPageContext.getPageActivity(), com.baidu.adp.lib.g.c.c(substring, 0L), null)));
                return true;
            }
            return false;
        }
        return false;
    }
}
