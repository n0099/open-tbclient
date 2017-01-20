package com.baidu.tieba.homepage.framework;

import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements c {
    final /* synthetic */ RecommendFrsControlFragment cud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cud = recommendFrsControlFragment;
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void u(int i, int i2, int i3) {
        q qVar;
        qVar = this.cud.ctQ;
        qVar.a(1, true, i, i2, 1, i3);
        if (com.baidu.adp.lib.util.i.fX()) {
            TiebaStatic.log(new ar("c11032").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void i(int i, int i2, int i3, int i4) {
        q qVar;
        qVar = this.cud.ctQ;
        qVar.a(2, false, i, i3, i2, i4);
        if (com.baidu.adp.lib.util.i.fX()) {
            TiebaStatic.log(new ar("c11032").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
        }
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void bo(List<TagInfo> list) {
        this.cud.bp(list);
    }

    @Override // com.baidu.tieba.homepage.framework.c
    public void ajn() {
        this.cud.ajq();
    }
}
