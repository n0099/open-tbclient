package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class e extends com.baidu.adp.base.g {
    final /* synthetic */ HotTopicActivity boA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HotTopicActivity hotTopicActivity) {
        this.boA = hotTopicActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (AntiHelper.la(this.boA.box.getErrorCode())) {
            AntiHelper.P(this.boA.getActivity(), this.boA.box.getErrorString());
        } else if (!StringUtils.isNull(this.boA.box.getErrorString())) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst(), this.boA.box.getErrorString());
        }
    }
}
