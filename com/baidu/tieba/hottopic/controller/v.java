package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class v extends com.baidu.adp.base.g {
    final /* synthetic */ RelateTopicForumActivity bGY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(RelateTopicForumActivity relateTopicForumActivity) {
        this.bGY = relateTopicForumActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (AntiHelper.ne(this.bGY.bGQ.getErrorCode())) {
            AntiHelper.Q(this.bGY.getActivity(), this.bGY.bGQ.getErrorString());
        } else if (!StringUtils.isNull(this.bGY.bGQ.getErrorString())) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst(), this.bGY.bGQ.getErrorString());
        }
    }
}
