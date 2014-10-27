package com.baidu.tieba.game;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends FragmentPagerAdapter {
    final /* synthetic */ GameCenterActivity aGO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(GameCenterActivity gameCenterActivity, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.aGO = gameCenterActivity;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        ao aoVar;
        ao aoVar2;
        bi biVar;
        bi biVar2;
        if (i < 0 || i >= getCount()) {
            return null;
        }
        if (i == 0) {
            biVar = this.aGO.aGM;
            if (biVar == null) {
                this.aGO.aGM = new bi();
            }
            biVar2 = this.aGO.aGM;
            return biVar2;
        }
        aoVar = this.aGO.aGN;
        if (aoVar == null) {
            this.aGO.aGN = new ao();
        }
        aoVar2 = this.aGO.aGN;
        return aoVar2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }
}
