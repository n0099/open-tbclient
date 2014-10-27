package com.baidu.tieba.game;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.game.view.GameCenterPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.tabHost.c {
    final /* synthetic */ GameCenterActivity aGO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(GameCenterActivity gameCenterActivity) {
        this.aGO = gameCenterActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        GameCenterPager gameCenterPager;
        FragmentTabWidget fragmentTabWidget;
        gameCenterPager = this.aGO.aGL;
        gameCenterPager.setCurrentItem(i);
        fragmentTabWidget = this.aGO.aGK;
        fragmentTabWidget.d(i, true);
    }
}
