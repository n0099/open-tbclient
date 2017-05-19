package com.baidu.tieba.homepage.framework;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements CustomMessageTask.CustomRunnable<Object> {
    final /* synthetic */ RecommendFrsControlFragment ctq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.ctq = recommendFrsControlFragment;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<ForumWriteData> run(CustomMessage<Object> customMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        scrollFragmentTabHost = this.ctq.ctc;
        bw currentFragment = scrollFragmentTabHost.getCurrentFragment();
        if (currentFragment == null || !this.ctq.isPrimary()) {
            return null;
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_MAINTAB_FORUM_INFO, currentFragment.Zv());
    }
}
