package com.baidu.tieba.frs.headvideo;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e bOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bOH = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        int i;
        TextureVideoView textureVideoView;
        int id = view.getId();
        imageView = this.bOH.aJL;
        if (id == imageView.getId()) {
            i = this.bOH.bOD;
            if (i == 2) {
                textureVideoView = this.bOH.aJJ;
                if (textureVideoView.isPlaying()) {
                    this.bOH.Zf();
                    return;
                } else {
                    this.bOH.IA();
                    return;
                }
            }
            this.bOH.IA();
        }
    }
}
