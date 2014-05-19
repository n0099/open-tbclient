package com.baidu.tieba.im.live.room;

import android.widget.ProgressBar;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bi a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bi biVar) {
        this.a = biVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        TbImageView tbImageView3;
        ProgressBar progressBar;
        if (aVar != null) {
            tbImageView = this.a.h;
            tbImageView.setBackgroundDrawable(null);
            tbImageView2 = this.a.h;
            tbImageView2.setImageBitmap(null);
            tbImageView3 = this.a.h;
            aVar.a(tbImageView3);
            progressBar = this.a.o;
            progressBar.setVisibility(8);
        }
    }
}
