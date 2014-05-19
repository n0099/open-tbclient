package com.baidu.tieba.faceshop;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ap apVar) {
        this.a = apVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        if (aVar != null) {
            tbImageView = this.a.f;
            tbImageView.invalidate();
        }
    }
}
