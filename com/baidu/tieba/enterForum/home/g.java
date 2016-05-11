package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ e aXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aXh = eVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void a(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            int lightStatusBarHeight = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(this.aXh.getActivity(), t.e.ds98) + i2;
            if (this.aXh.aWX != null) {
                this.aXh.aWX.fP(lightStatusBarHeight);
            }
            if (this.aXh.aWY != null && this.aXh.aWY.aYq != null) {
                this.aXh.aWY.aYq.fP(lightStatusBarHeight);
            }
        }
    }
}
