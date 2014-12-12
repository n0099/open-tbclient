package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.core.util.bj {
    Pattern frsPattern = Pattern.compile("http://tieba.baidu.com/f\\?kw=([^&]+)");

    @Override // com.baidu.tbadk.core.util.bj
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        String substring;
        if (strArr == null || strArr[0] == null) {
            return false;
        }
        String lowerCase = strArr[0].toLowerCase();
        String str = null;
        Matcher matcher = this.frsPattern.matcher(lowerCase);
        if (strArr.length > 1) {
            str = strArr[1];
        }
        if (matcher.find()) {
            substring = matcher.group(1);
        } else if (!lowerCase.startsWith("frs:")) {
            return false;
        } else {
            substring = lowerCase.substring(4);
        }
        if (tbPageContext != null) {
            tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(substring, str)));
            return true;
        }
        return false;
    }
}
