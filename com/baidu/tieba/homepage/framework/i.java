package com.baidu.tieba.homepage.framework;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements CustomMessageTask.CustomRunnable<Object> {
    final /* synthetic */ RecommendFrsControlFragment czI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.czI = recommendFrsControlFragment;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<ForumWriteData> run(CustomMessage<Object> customMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        scrollFragmentTabHost = this.czI.czu;
        bx currentFragment = scrollFragmentTabHost.getCurrentFragment();
        if (currentFragment == null || !this.czI.isPrimary()) {
            return null;
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO, currentFragment.aay());
    }
}
