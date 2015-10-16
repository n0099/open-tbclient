package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class l extends com.baidu.adp.base.g {
    final /* synthetic */ RelateTopicForumActivity boP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RelateTopicForumActivity relateTopicForumActivity) {
        this.boP = relateTopicForumActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (AntiHelper.lc(this.boP.boI.getErrorCode())) {
            AntiHelper.P(this.boP.getActivity(), this.boP.boI.getErrorString());
        } else if (!StringUtils.isNull(this.boP.boI.getErrorString())) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst(), this.boP.boI.getErrorString());
        }
    }
}
