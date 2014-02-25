package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ aa a;
    private final /* synthetic */ ViewGroup b;
    private final /* synthetic */ ae c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, ViewGroup viewGroup, ae aeVar) {
        this.a = aaVar;
        this.b = viewGroup;
        this.c = aeVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.b.findViewWithTag(str);
        if (headImageView != null && bVar != null) {
            headImageView.invalidate();
        } else {
            this.c.a = false;
        }
    }
}
