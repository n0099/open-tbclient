package com.baidu.tieba.frs.c;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
/* loaded from: classes.dex */
class j implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ a aQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.aQd = aVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        ImageView imageView = new ImageView(this.aQd.getPageContext().getPageActivity());
        imageView.setBackgroundResource(p.good_threads_tip);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gE() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gF() {
        return 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return (int) ((this.aQd.getResources().getDimensionPixelSize(o.ds80) - 0.5f) / this.aQd.getResources().getDisplayMetrics().density);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 0;
    }
}
