package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        if (dVar != null) {
            bkVar = this.a.n;
            if (bkVar != null) {
                bkVar2 = this.a.n;
                if (bkVar2.D() != null) {
                    bkVar3 = this.a.n;
                    View findViewWithTag = bkVar3.D().findViewWithTag(str);
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
