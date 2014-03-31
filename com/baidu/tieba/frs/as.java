package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
final class as implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        if (bVar != null) {
            cmVar = this.a.r;
            if (cmVar != null) {
                cmVar2 = this.a.r;
                if (cmVar2.I() != null) {
                    cmVar3 = this.a.r;
                    View findViewWithTag = cmVar3.I().findViewWithTag(str);
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
