package com.baidu.tieba.data.emotions;

import com.baidu.adp.widget.ImageView.BDImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ EmotionImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EmotionImageActivity emotionImageActivity) {
        this.a = emotionImageActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        boolean z2;
        String str2;
        BDImageView bDImageView;
        z2 = this.a.q;
        if (!z2 && bVar != null) {
            str2 = this.a.h;
            if (str2.equals(str)) {
                bDImageView = this.a.c;
                bVar.a(bDImageView);
            }
        }
    }
}
