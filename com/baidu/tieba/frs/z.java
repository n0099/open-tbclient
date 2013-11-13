package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class z implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1370a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.f1370a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        if (eVar != null) {
            bnVar = this.f1370a.n;
            if (bnVar != null) {
                bnVar2 = this.f1370a.n;
                if (bnVar2.B() != null) {
                    bnVar3 = this.f1370a.n;
                    View findViewWithTag = bnVar3.B().findViewWithTag(str);
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
