package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class l extends com.baidu.adp.base.g {
    final /* synthetic */ RelateTopicForumActivity bpt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RelateTopicForumActivity relateTopicForumActivity) {
        this.bpt = relateTopicForumActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (AntiHelper.lr(this.bpt.bpm.getErrorCode())) {
            AntiHelper.Q(this.bpt.getActivity(), this.bpt.bpm.getErrorString());
        } else if (!StringUtils.isNull(this.bpt.bpm.getErrorString())) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst(), this.bpt.bpm.getErrorString());
        }
    }
}
