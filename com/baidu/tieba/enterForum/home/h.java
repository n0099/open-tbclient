package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ f bGP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.bGP = fVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void a(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            int lightStatusBarHeight = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.bGP.getActivity(), w.f.ds98) + i2;
            if (this.bGP.bGG != null) {
                this.bGP.bGG.hw(lightStatusBarHeight);
            }
        }
    }
}
