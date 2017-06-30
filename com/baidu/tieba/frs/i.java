package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.w;
import java.net.URLDecoder;
/* loaded from: classes.dex */
class i implements be.a {
    @Override // com.baidu.tbadk.core.util.be.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        boolean z;
        String substring;
        boolean z2;
        String str;
        String str2 = null;
        boolean z3 = false;
        if (strArr == null || strArr[0] == null) {
            return 3;
        }
        String lowerCase = strArr[0].toLowerCase();
        String str3 = strArr.length > 1 ? strArr[1] : null;
        if (lowerCase != null && (lowerCase.startsWith("http://tieba.baidu.com/f?") || lowerCase.startsWith("http://tieba.baidu.com/f?"))) {
            if (lowerCase.startsWith("http://tieba.baidu.com/f?")) {
                substring = lowerCase.substring("http://tieba.baidu.com/f?".length());
            } else {
                substring = lowerCase.startsWith("http://tieba.baidu.com/f?") ? lowerCase.substring("http://tieba.baidu.com/f?".length()) : null;
            }
            if (substring != null) {
                String[] split = substring.split("&");
                int i = 0;
                while (true) {
                    if (i < split.length) {
                        if (split[i] == null || !split[i].startsWith("kw=")) {
                            i++;
                        } else {
                            str = split[i].substring(3);
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        str = null;
                        break;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    boolean z4 = z2;
                    z = false;
                    z3 = z4;
                } else {
                    str2 = URLDecoder.decode(str);
                    boolean z5 = z2;
                    z = false;
                    z3 = z5;
                }
            }
            z = false;
        } else if (!lowerCase.startsWith("frs:")) {
            if (lowerCase.startsWith("com.baidu.tieba://?tname=")) {
                str2 = lowerCase.substring("com.baidu.tieba://?tname=".length());
                z = true;
            } else if (!lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) || !lowerCase.contains("kw=")) {
                return 3;
            } else {
                str2 = com.baidu.tbadk.util.ab.aq(lowerCase, "kw=");
                if (!TextUtils.isEmpty(str2) && tbPageContext != null) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str2, str3)));
                    return 0;
                }
                z = false;
            }
        } else {
            str2 = lowerCase.substring(4);
            z = false;
            z3 = true;
        }
        if (!TextUtils.isEmpty(str2) && tbPageContext != null) {
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str2, str3)));
            return 1;
        } else if (z && !TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.g.i.h(TbadkCoreApplication.m9getInst(), com.baidu.tieba.frs.e.p.ah(TbadkCoreApplication.m9getInst(), str2));
            com.baidu.tieba.frs.e.o.au(2, 2);
            return 1;
        } else if (z3) {
            tbPageContext.showToast(w.l.page_not_found);
            return 1;
        } else {
            return 3;
        }
    }
}
