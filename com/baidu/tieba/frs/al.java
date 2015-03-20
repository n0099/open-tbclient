package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
/* loaded from: classes.dex */
class al implements com.baidu.tbadk.core.util.bm {
    @Override // com.baidu.tbadk.core.util.bm
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        String str;
        String str2 = null;
        if (strArr == null || strArr[0] == null) {
            return false;
        }
        String lowerCase = strArr[0].toLowerCase();
        String str3 = strArr.length > 1 ? strArr[1] : null;
        if (lowerCase != null && lowerCase.startsWith("http://tieba.baidu.com/f?")) {
            String substring = lowerCase.substring("http://tieba.baidu.com/f?".length());
            if (substring != null) {
                String[] split = substring.split("&");
                if (!substring.startsWith("kw=")) {
                    int i = 0;
                    while (true) {
                        if (i < split.length) {
                            if (split[i] == null || !split[i].startsWith("kw=")) {
                                i++;
                            } else {
                                str = split[i].substring(3);
                                break;
                            }
                        } else {
                            str = null;
                            break;
                        }
                    }
                } else {
                    str = substring.substring(3);
                }
                if (!TextUtils.isEmpty(str)) {
                    str2 = str;
                }
            }
        } else if (!lowerCase.startsWith("frs:")) {
            return false;
        } else {
            str2 = lowerCase.substring(4);
        }
        if (tbPageContext != null) {
            tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str2, str3)));
            return true;
        }
        return false;
    }
}
