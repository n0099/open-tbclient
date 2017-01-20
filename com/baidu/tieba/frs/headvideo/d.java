package com.baidu.tieba.frs.headvideo;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c bRb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bRb = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        int i;
        aj ajVar;
        aj ajVar2;
        QuickVideoView quickVideoView;
        aj ajVar3;
        aj ajVar4;
        int id = view.getId();
        imageView = this.bRb.aNc;
        if (id == imageView.getId()) {
            i = this.bRb.bQX;
            if (i == 2) {
                quickVideoView = this.bRb.aMY;
                if (quickVideoView.isPlaying()) {
                    this.bRb.pausePlay();
                    return;
                }
                this.bRb.startPlay();
                ajVar3 = this.bRb.aMm;
                if (ajVar3 != null) {
                    ajVar4 = this.bRb.aMm;
                    ajVar4.pD("2");
                    return;
                }
                return;
            }
            this.bRb.startPlay();
            ajVar = this.bRb.aMm;
            if (ajVar != null) {
                ajVar2 = this.bRb.aMm;
                ajVar2.pD("2");
            }
        }
    }
}
