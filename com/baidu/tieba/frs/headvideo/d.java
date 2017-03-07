package com.baidu.tieba.frs.headvideo;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c bYj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bYj = cVar;
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
        imageView = this.bYj.aSP;
        if (id == imageView.getId()) {
            i = this.bYj.bYf;
            if (i == 2) {
                quickVideoView = this.bYj.aSL;
                if (quickVideoView.isPlaying()) {
                    this.bYj.pausePlay();
                    return;
                }
                this.bYj.startPlay();
                ajVar3 = this.bYj.aRZ;
                if (ajVar3 != null) {
                    ajVar4 = this.bYj.aRZ;
                    ajVar4.oM("2");
                    return;
                }
                return;
            }
            this.bYj.startPlay();
            ajVar = this.bYj.aRZ;
            if (ajVar != null) {
                ajVar2 = this.bYj.aRZ;
                ajVar2.oM("2");
            }
        }
    }
}
