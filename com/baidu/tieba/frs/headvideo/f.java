package com.baidu.tieba.frs.headvideo;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e cbB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cbB = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        int i;
        TextureVideoView textureVideoView;
        TextureVideoView textureVideoView2;
        TextureVideoView textureVideoView3;
        int id = view.getId();
        imageView = this.cbB.aPk;
        if (id == imageView.getId()) {
            i = this.cbB.cbx;
            if (i == 2) {
                textureVideoView2 = this.cbB.aPh;
                if (textureVideoView2.isPlaying()) {
                    this.cbB.pausePlay();
                    return;
                }
                this.cbB.Kz();
                textureVideoView3 = this.cbB.aPh;
                textureVideoView3.setPlayMode("2");
                return;
            }
            this.cbB.Kz();
            textureVideoView = this.cbB.aPh;
            textureVideoView.setPlayMode("2");
        }
    }
}
