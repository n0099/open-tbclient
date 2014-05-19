package com.baidu.tieba.faceshop;

import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ EmotionImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionImageActivity emotionImageActivity) {
        this.a = emotionImageActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        boolean z2;
        String str2;
        TbImageView tbImageView;
        z2 = this.a.q;
        if (!z2 && aVar != null) {
            str2 = this.a.h;
            if (str2.equals(str)) {
                tbImageView = this.a.c;
                aVar.a(tbImageView);
            }
        }
    }
}
