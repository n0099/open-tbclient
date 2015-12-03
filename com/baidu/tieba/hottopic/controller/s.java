package com.baidu.tieba.hottopic.controller;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class s implements bf.a {
    @Override // com.baidu.tbadk.core.util.bf.a
    public boolean a(TbPageContext<?> tbPageContext, String[] strArr) {
        String lowerCase;
        if (strArr == null || strArr.length == 0 || strArr[0] == null || (lowerCase = strArr[0].toLowerCase()) == null || !lowerCase.startsWith("http://tieba.baidu.com/mo/q/hotMessage?topic_id=")) {
            return false;
        }
        String substring = lowerCase.substring("http://tieba.baidu.com/mo/q/hotMessage?topic_id=".length());
        boolean z = !TextUtils.isEmpty(substring);
        if (!StringUtils.isNull(substring, true) && tbPageContext != null) {
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(substring, null, null)));
            return true;
        } else if (z) {
            tbPageContext.showToast(n.i.page_not_found);
            return true;
        } else {
            return false;
        }
    }
}
