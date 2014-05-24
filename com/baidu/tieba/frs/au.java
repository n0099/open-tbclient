package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class au implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        if (aVar != null) {
            ctVar = this.a.w;
            if (ctVar != null) {
                ctVar2 = this.a.w;
                if (ctVar2.L() != null) {
                    ctVar3 = this.a.w;
                    View findViewWithTag = ctVar3.L().findViewWithTag(str);
                    if (findViewWithTag != null) {
                        if (findViewWithTag instanceof HeadImageView) {
                            ((HeadImageView) findViewWithTag).invalidate();
                        } else if (findViewWithTag instanceof TbImageView) {
                            ((TbImageView) findViewWithTag).invalidate();
                        } else {
                            findViewWithTag.invalidate();
                        }
                    }
                }
            }
        }
    }
}
