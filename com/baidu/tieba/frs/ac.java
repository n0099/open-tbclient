package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class ac implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        br brVar;
        br brVar2;
        br brVar3;
        if (bVar != null) {
            brVar = this.a.p;
            if (brVar != null) {
                brVar2 = this.a.p;
                if (brVar2.D() != null) {
                    brVar3 = this.a.p;
                    View findViewWithTag = brVar3.D().findViewWithTag(str);
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
