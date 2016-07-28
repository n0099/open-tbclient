package com.baidu.tieba.frs.headvideo;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e bQt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bQt = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        int i;
        TextureVideoView textureVideoView;
        TextureVideoView textureVideoView2;
        TextureVideoView textureVideoView3;
        int id = view.getId();
        imageView = this.bQt.aKE;
        if (id == imageView.getId()) {
            i = this.bQt.bQp;
            if (i == 2) {
                textureVideoView2 = this.bQt.aKC;
                if (textureVideoView2.isPlaying()) {
                    this.bQt.ZB();
                    return;
                }
                this.bQt.Iz();
                textureVideoView3 = this.bQt.aKC;
                textureVideoView3.setPlayMode("2");
                return;
            }
            this.bQt.Iz();
            textureVideoView = this.bQt.aKC;
            textureVideoView.setPlayMode("2");
        }
    }
}
