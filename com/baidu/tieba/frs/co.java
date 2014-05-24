package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class co implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        cq cqVar;
        try {
            cqVar = this.a.o;
            View findViewWithTag = cqVar.l().a(2).findViewWithTag(str);
            if (findViewWithTag != null && (findViewWithTag instanceof TbImageView)) {
                findViewWithTag.invalidate();
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "imageLoaded", e.getMessage());
        }
    }
}
