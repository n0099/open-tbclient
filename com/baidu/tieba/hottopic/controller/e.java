package com.baidu.tieba.hottopic.controller;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class e extends com.baidu.adp.base.g {
    final /* synthetic */ HotTopicActivity bpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(HotTopicActivity hotTopicActivity) {
        this.bpp = hotTopicActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (AntiHelper.lr(this.bpp.bpm.getErrorCode())) {
            AntiHelper.Q(this.bpp.getActivity(), this.bpp.bpm.getErrorString());
        } else if (!StringUtils.isNull(this.bpp.bpm.getErrorString())) {
            com.baidu.adp.lib.util.k.showToast(TbadkCoreApplication.m411getInst(), this.bpp.bpm.getErrorString());
        }
    }
}
