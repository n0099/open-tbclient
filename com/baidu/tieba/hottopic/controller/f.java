package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class f extends com.baidu.adp.base.g {
    final /* synthetic */ HotTopicActivity bDn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(HotTopicActivity hotTopicActivity) {
        this.bDn = hotTopicActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (AntiHelper.mC(this.bDn.bDm.getErrorCode())) {
            AntiHelper.Q(this.bDn.getActivity(), this.bDn.bDm.getErrorString());
        } else if (!StringUtils.isNull(this.bDn.bDm.getErrorString())) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst(), this.bDn.bDm.getErrorString());
        }
    }
}
