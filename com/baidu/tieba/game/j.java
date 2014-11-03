package com.baidu.tieba.game;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.game.view.GameCenterPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.tabHost.c {
    final /* synthetic */ GameCenterActivity aGY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(GameCenterActivity gameCenterActivity) {
        this.aGY = gameCenterActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        GameCenterPager gameCenterPager;
        FragmentTabWidget fragmentTabWidget;
        gameCenterPager = this.aGY.aGV;
        gameCenterPager.setCurrentItem(i);
        fragmentTabWidget = this.aGY.aGU;
        fragmentTabWidget.d(i, true);
    }
}
