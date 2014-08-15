package com.baidu.tieba.im.live.room;

import android.widget.ProgressBar;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bk bkVar) {
        this.a = bkVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        TbImageView tbImageView3;
        ProgressBar progressBar;
        super.a((bn) aVar, str, i);
        if (aVar != null) {
            tbImageView = this.a.f;
            tbImageView.setBackgroundDrawable(null);
            tbImageView2 = this.a.f;
            tbImageView2.setImageDrawable(null);
            tbImageView3 = this.a.f;
            aVar.a(tbImageView3);
            progressBar = this.a.m;
            progressBar.setVisibility(8);
        }
    }
}
