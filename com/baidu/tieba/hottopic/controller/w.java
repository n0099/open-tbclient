package com.baidu.tieba.hottopic.controller;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class w implements be.a {
    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    @Override // com.baidu.tbadk.core.util.be.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        String str;
        boolean z;
        if (strArr == null || strArr.length == 0 || strArr[0] == null) {
            return 3;
        }
        String lowerCase = strArr[0].toLowerCase();
        if (lowerCase == null || !lowerCase.startsWith("http://tieba.baidu.com/mo/q/hotmessage?topic_id=")) {
            return 3;
        }
        String substring = lowerCase.substring("http://tieba.baidu.com/mo/q/hotmessage?topic_id=".length());
        if (!TextUtils.isEmpty(substring)) {
            if (substring.indexOf("&") != -1) {
                substring = substring.split("&")[0];
            }
            if (!TextUtils.isEmpty(substring)) {
                str = substring;
                z = true;
                if (StringUtils.isNull(str, true) && tbPageContext != null) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(str, null, null)));
                    return 1;
                } else if (z) {
                    return 3;
                } else {
                    tbPageContext.showToast(t.j.page_not_found);
                    return 1;
                }
            }
        }
        str = substring;
        z = false;
        if (StringUtils.isNull(str, true)) {
        }
        if (z) {
        }
    }
}
