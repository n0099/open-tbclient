package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class j extends com.baidu.adp.base.g {
    final /* synthetic */ HotTopicActivity bKr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(HotTopicActivity hotTopicActivity) {
        this.bKr = hotTopicActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (AntiHelper.or(this.bKr.bKp.getErrorCode())) {
            AntiHelper.X(this.bKr.getActivity(), this.bKr.bKp.getErrorString());
        } else if (!StringUtils.isNull(this.bKr.bKp.getErrorString())) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst(), this.bKr.bKp.getErrorString());
        }
    }
}
