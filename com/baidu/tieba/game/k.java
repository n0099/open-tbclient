package com.baidu.tieba.game;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends FragmentPagerAdapter {
    final /* synthetic */ GameCenterActivity aGY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(GameCenterActivity gameCenterActivity, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.aGY = gameCenterActivity;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        ao aoVar;
        ao aoVar2;
        bj bjVar;
        bj bjVar2;
        if (i < 0 || i >= getCount()) {
            return null;
        }
        if (i == 0) {
            bjVar = this.aGY.aGW;
            if (bjVar == null) {
                this.aGY.aGW = new bj();
            }
            bjVar2 = this.aGY.aGW;
            return bjVar2;
        }
        aoVar = this.aGY.aGX;
        if (aoVar == null) {
            this.aGY.aGX = new ao();
        }
        aoVar2 = this.aGY.aGX;
        return aoVar2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }
}
