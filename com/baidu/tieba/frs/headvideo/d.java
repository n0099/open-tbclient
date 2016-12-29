package com.baidu.tieba.frs.headvideo;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.ah;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c bKI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bKI = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        int i;
        ah ahVar;
        ah ahVar2;
        QuickVideoView quickVideoView;
        ah ahVar3;
        ah ahVar4;
        int id = view.getId();
        imageView = this.bKI.aNZ;
        if (id == imageView.getId()) {
            i = this.bKI.bKE;
            if (i == 2) {
                quickVideoView = this.bKI.aNV;
                if (quickVideoView.isPlaying()) {
                    this.bKI.pausePlay();
                    return;
                }
                this.bKI.startPlay();
                ahVar3 = this.bKI.aNk;
                if (ahVar3 != null) {
                    ahVar4 = this.bKI.aNk;
                    ahVar4.pm("2");
                    return;
                }
                return;
            }
            this.bKI.startPlay();
            ahVar = this.bKI.aNk;
            if (ahVar != null) {
                ahVar2 = this.bKI.aNk;
                ahVar2.pm("2");
            }
        }
    }
}
