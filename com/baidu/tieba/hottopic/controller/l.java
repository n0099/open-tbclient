package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class l extends com.baidu.adp.base.g {
    final /* synthetic */ RelateTopicForumActivity boE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(RelateTopicForumActivity relateTopicForumActivity) {
        this.boE = relateTopicForumActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (AntiHelper.la(this.boE.box.getErrorCode())) {
            AntiHelper.P(this.boE.getActivity(), this.boE.box.getErrorString());
        } else if (!StringUtils.isNull(this.boE.box.getErrorString())) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst(), this.boE.box.getErrorString());
        }
    }
}
