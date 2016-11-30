package com.baidu.tieba.frs.headvideo;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.ah;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c ceZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.ceZ = cVar;
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
        imageView = this.ceZ.aOI;
        if (id == imageView.getId()) {
            i = this.ceZ.ceV;
            if (i == 2) {
                quickVideoView = this.ceZ.aOE;
                if (quickVideoView.isPlaying()) {
                    this.ceZ.pausePlay();
                    return;
                }
                this.ceZ.JT();
                ahVar3 = this.ceZ.aNT;
                if (ahVar3 != null) {
                    ahVar4 = this.ceZ.aNT;
                    ahVar4.qK("2");
                    return;
                }
                return;
            }
            this.ceZ.JT();
            ahVar = this.ceZ.aNT;
            if (ahVar != null) {
                ahVar2 = this.ceZ.aNT;
                ahVar2.qK("2");
            }
        }
    }
}
