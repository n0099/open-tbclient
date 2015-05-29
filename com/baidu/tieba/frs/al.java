package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
/* loaded from: classes.dex */
class al implements com.baidu.tbadk.core.util.bk {
    @Override // com.baidu.tbadk.core.util.bk
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        boolean z;
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
                if (!TextUtils.isEmpty(str)) {
                    str2 = str;
                    z = false;
                }
            }
            z = false;
        } else if (!lowerCase.startsWith("frs:")) {
            if (!lowerCase.startsWith("com.baidu.tieba://?tname=")) {
                return false;
            }
            str2 = lowerCase.substring("com.baidu.tieba://?tname=".length());
            z = true;
        } else {
            str2 = lowerCase.substring(4);
            z = false;
        }
        if (!TextUtils.isEmpty(str2) && tbPageContext != null) {
            tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str2, str3)));
            return true;
        } else if (!z || TextUtils.isEmpty(str2)) {
            return false;
        } else {
            com.baidu.adp.lib.g.j.f(TbadkCoreApplication.m411getInst(), com.baidu.tieba.frs.utils.a.K(TbadkCoreApplication.m411getInst(), str2));
            return true;
        }
    }
}
