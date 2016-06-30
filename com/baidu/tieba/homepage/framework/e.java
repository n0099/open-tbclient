package com.baidu.tieba.homepage.framework;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ RecommendFrsControlFragment cow;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
        super(i);
        this.cow = recommendFrsControlFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        if (customResponsedMessage != null) {
            Object data = customResponsedMessage.getData();
            if (data instanceof TagInfo) {
                TagInfo tagInfo = (TagInfo) data;
                scrollFragmentTabHost = this.cow.coi;
                if (scrollFragmentTabHost != null) {
                    scrollFragmentTabHost2 = this.cow.coi;
                    int bl = scrollFragmentTabHost2.bl(tagInfo.tag_code.longValue());
                    if (bl >= 0) {
                        scrollFragmentTabHost3 = this.cow.coi;
                        scrollFragmentTabHost3.setCurrentTab(bl);
                    }
                }
            }
        }
    }
}
