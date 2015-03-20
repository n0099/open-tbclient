package com.baidu.tieba.frs.c;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class j implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ a aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.aNz = aVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        ImageView imageView = new ImageView(this.aNz.getPageContext().getPageActivity());
        imageView.setBackgroundResource(u.good_threads_tip);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gT() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gU() {
        return 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return (int) ((this.aNz.getResources().getDimensionPixelSize(t.ds80) - 0.5f) / this.aNz.getResources().getDisplayMetrics().density);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 0;
    }
}
