package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ f bxz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.bxz = fVar;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            int lightStatusBarHeight = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.bxz.getActivity(), r.f.ds98) + i2;
            if (this.bxz.bxq != null) {
                this.bxz.bxq.hr(lightStatusBarHeight);
            }
        }
    }
}
