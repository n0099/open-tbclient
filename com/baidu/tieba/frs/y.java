package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class y implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        bo boVar;
        bo boVar2;
        bo boVar3;
        if (dVar != null) {
            boVar = this.a.n;
            if (boVar != null) {
                boVar2 = this.a.n;
                if (boVar2.D() != null) {
                    boVar3 = this.a.n;
                    View findViewWithTag = boVar3.D().findViewWithTag(str);
                    if (findViewWithTag != null) {
                        if (findViewWithTag instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) findViewWithTag;
                            if (!tbImageView.getIsLoaded()) {
                                tbImageView.invalidate();
                                return;
                            }
                            return;
                        }
                        findViewWithTag.invalidate();
                    }
                }
            }
        }
    }
}
