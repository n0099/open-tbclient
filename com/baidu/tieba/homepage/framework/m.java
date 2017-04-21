package com.baidu.tieba.homepage.framework;

import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements c {
    final /* synthetic */ RecommendFrsControlFragment cwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cwt = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void u(int i, int i2, int i3) {
        q qVar;
        qVar = this.cwt.cwg;
        qVar.a(1, true, i, i2, 1, i3);
        if (com.baidu.adp.lib.util.i.gY()) {
            TiebaStatic.log(new as("c11032").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void i(int i, int i2, int i3, int i4) {
        q qVar;
        qVar = this.cwt.cwg;
        qVar.a(2, false, i, i3, i2, i4);
        if (com.baidu.adp.lib.util.i.gY()) {
            TiebaStatic.log(new as("c11032").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void aU(List<TagInfo> list) {
        this.cwt.aV(list);
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void ajv() {
        this.cwt.ajy();
    }
}
