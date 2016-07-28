package com.baidu.tieba.homepage.framework;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements CustomMessageTask.CustomRunnable<Boolean> {
    final /* synthetic */ RecommendFrsControlFragment cqJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cqJ = recommendFrsControlFragment;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.cqJ.cqw;
        if (scrollFragmentTabHost.aha()) {
            scrollFragmentTabHost2 = this.cqJ.cqw;
            if (scrollFragmentTabHost2.crp) {
                scrollFragmentTabHost3 = this.cqJ.cqw;
                scrollFragmentTabHost3.ahc();
                scrollFragmentTabHost4 = this.cqJ.cqw;
                scrollFragmentTabHost4.crp = false;
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, true);
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, false);
    }
}
