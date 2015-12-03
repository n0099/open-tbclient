package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class av implements bf.a {
    @Override // com.baidu.tbadk.core.util.bf.a
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        boolean z;
        boolean z2;
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
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        str = null;
                        break;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    z2 = false;
                } else {
                    str2 = str;
                    z2 = false;
                }
            } else {
                z = false;
                z2 = false;
            }
        } else if (lowerCase.startsWith("frs:")) {
            str2 = lowerCase.substring(4);
            z = true;
            z2 = false;
        } else if (lowerCase.startsWith("homework:")) {
            FrsActivityStatic.j(tbPageContext);
            return true;
        } else if (!lowerCase.startsWith("com.baidu.tieba://?tname=")) {
            return false;
        } else {
            str2 = lowerCase.substring("com.baidu.tieba://?tname=".length());
            z = false;
            z2 = true;
        }
        if (!TextUtils.isEmpty(str2) && tbPageContext != null) {
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(str2, str3)));
            return true;
        } else if (z2 && !TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.h.i.f(TbadkCoreApplication.m411getInst(), com.baidu.tieba.frs.utils.a.L(TbadkCoreApplication.m411getInst(), str2));
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10320").r("obj_locate", 2).r("obj_type", 2));
            return true;
        } else if (z) {
            tbPageContext.showToast(n.i.page_not_found);
            return true;
        } else {
            return false;
        }
    }
}
