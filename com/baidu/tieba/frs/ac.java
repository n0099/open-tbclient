package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
final class ac implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        if (bVar != null) {
            bsVar = this.a.p;
            if (bsVar != null) {
                bsVar2 = this.a.p;
                if (bsVar2.B() != null) {
                    bsVar3 = this.a.p;
                    View findViewWithTag = bsVar3.B().findViewWithTag(str);
                    if (findViewWithTag != null) {
                        if (findViewWithTag instanceof HeadImageView) {
                            ((HeadImageView) findViewWithTag).invalidate();
                        } else if (findViewWithTag instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) findViewWithTag;
                            if (!tbImageView.getIsLoaded()) {
                                tbImageView.invalidate();
                            }
                        } else {
                            findViewWithTag.invalidate();
                        }
                    }
                }
            }
        }
    }
}
