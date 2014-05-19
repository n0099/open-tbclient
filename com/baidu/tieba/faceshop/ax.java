package com.baidu.tieba.faceshop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class ax implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ aw a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar, ViewGroup viewGroup) {
        this.a = awVar;
        this.b = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        View findViewWithTag = this.b.findViewWithTag(str);
        if (aVar != null && findViewWithTag != null && (findViewWithTag instanceof TbImageView)) {
            TbImageView tbImageView = (TbImageView) findViewWithTag;
            aVar.a(tbImageView);
            tbImageView.setTag(null);
        }
    }
}
