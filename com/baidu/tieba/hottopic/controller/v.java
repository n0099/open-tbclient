package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class v extends com.baidu.adp.base.g {
    final /* synthetic */ RelateTopicForumActivity bDu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(RelateTopicForumActivity relateTopicForumActivity) {
        this.bDu = relateTopicForumActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (AntiHelper.mC(this.bDu.bDm.getErrorCode())) {
            AntiHelper.Q(this.bDu.getActivity(), this.bDu.bDm.getErrorString());
        } else if (!StringUtils.isNull(this.bDu.bDm.getErrorString())) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst(), this.bDu.bDm.getErrorString());
        }
    }
}
