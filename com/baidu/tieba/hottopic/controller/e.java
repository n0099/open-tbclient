package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class e extends com.baidu.adp.base.g {
    final /* synthetic */ HotTopicActivity boL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HotTopicActivity hotTopicActivity) {
        this.boL = hotTopicActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (AntiHelper.lc(this.boL.boI.getErrorCode())) {
            AntiHelper.P(this.boL.getActivity(), this.boL.boI.getErrorString());
        } else if (!StringUtils.isNull(this.boL.boI.getErrorString())) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst(), this.boL.boI.getErrorString());
        }
    }
}
