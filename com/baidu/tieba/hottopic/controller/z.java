package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class z extends com.baidu.adp.base.g {
    final /* synthetic */ RelateTopicForumActivity bKy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(RelateTopicForumActivity relateTopicForumActivity) {
        this.bKy = relateTopicForumActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (AntiHelper.or(this.bKy.bKp.getErrorCode())) {
            AntiHelper.X(this.bKy.getActivity(), this.bKy.bKp.getErrorString());
        } else if (!StringUtils.isNull(this.bKy.bKp.getErrorString())) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst(), this.bKy.bKp.getErrorString());
        }
    }
}
