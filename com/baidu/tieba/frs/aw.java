package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class aw implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        cs csVar;
        cs csVar2;
        cs csVar3;
        if (aVar != null) {
            csVar = this.a.w;
            if (csVar != null) {
                csVar2 = this.a.w;
                if (csVar2.L() != null) {
                    csVar3 = this.a.w;
                    View findViewWithTag = csVar3.L().findViewWithTag(str);
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
