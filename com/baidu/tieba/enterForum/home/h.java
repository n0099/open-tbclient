package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ f bEF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.bEF = fVar;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            int lightStatusBarHeight = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.bEF.getActivity(), w.f.ds98) + i2;
            if (this.bEF.bEw != null) {
                this.bEF.bEw.hn(lightStatusBarHeight);
            }
        }
    }
}
