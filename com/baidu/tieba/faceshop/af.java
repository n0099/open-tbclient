package com.baidu.tieba.faceshop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class af implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ ViewGroup a;
    final /* synthetic */ ae b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, ViewGroup viewGroup) {
        this.b = aeVar;
        this.a = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        View findViewWithTag = this.a.findViewWithTag(str);
        if (dVar != null && findViewWithTag != null && (findViewWithTag instanceof TbImageView)) {
            TbImageView tbImageView = (TbImageView) findViewWithTag;
            dVar.a(tbImageView);
            tbImageView.setTag(null);
        }
    }
}
