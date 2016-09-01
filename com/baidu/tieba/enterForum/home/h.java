package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ e bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.bGG = eVar;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            int lightStatusBarHeight = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.bGG.getActivity(), t.e.ds98) + i2;
            if (this.bGG.bGw != null) {
                this.bGG.bGw.hq(lightStatusBarHeight);
            }
        }
    }
}
