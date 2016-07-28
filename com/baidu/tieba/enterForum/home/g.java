package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ e bvs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.bvs = eVar;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            int lightStatusBarHeight = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(this.bvs.getActivity(), u.e.ds98) + i2;
            if (this.bvs.bvj != null) {
                this.bvs.bvj.gO(lightStatusBarHeight);
            }
            if (this.bvs.bvk != null && this.bvs.bvk.bww != null) {
                this.bvs.bvk.bww.gO(lightStatusBarHeight);
            }
        }
    }
}
