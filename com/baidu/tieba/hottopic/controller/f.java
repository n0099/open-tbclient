package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class f extends com.baidu.adp.base.g {
    final /* synthetic */ HotTopicActivity bGR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(HotTopicActivity hotTopicActivity) {
        this.bGR = hotTopicActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (AntiHelper.ne(this.bGR.bGQ.getErrorCode())) {
            AntiHelper.Q(this.bGR.getActivity(), this.bGR.bGQ.getErrorString());
        } else if (!StringUtils.isNull(this.bGR.bGQ.getErrorString())) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst(), this.bGR.bGQ.getErrorString());
        }
    }
}
