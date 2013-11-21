package com.baidu.tieba.flist;

import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class af implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ae f1246a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.f1246a = aeVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (eVar != null) {
            tbImageView = this.f1246a.f1245a.e;
            tbImageView.requestLayout();
            tbImageView2 = this.f1246a.f1245a.e;
            tbImageView2.invalidate();
        }
    }
}
