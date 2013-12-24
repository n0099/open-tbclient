package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class z implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        if (eVar != null) {
            bnVar = this.a.n;
            if (bnVar != null) {
                bnVar2 = this.a.n;
                if (bnVar2.C() != null) {
                    bnVar3 = this.a.n;
                    View findViewWithTag = bnVar3.C().findViewWithTag(str);
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
