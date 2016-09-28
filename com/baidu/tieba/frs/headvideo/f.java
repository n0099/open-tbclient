package com.baidu.tieba.frs.headvideo;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e cbD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cbD = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        int i;
        com.baidu.tieba.play.s sVar;
        com.baidu.tieba.play.s sVar2;
        QuickVideoView quickVideoView;
        com.baidu.tieba.play.s sVar3;
        com.baidu.tieba.play.s sVar4;
        int id = view.getId();
        imageView = this.cbD.aMJ;
        if (id == imageView.getId()) {
            i = this.cbD.cbz;
            if (i == 2) {
                quickVideoView = this.cbD.aMF;
                if (quickVideoView.isPlaying()) {
                    this.cbD.pausePlay();
                    return;
                }
                this.cbD.Js();
                sVar3 = this.cbD.aLZ;
                if (sVar3 != null) {
                    sVar4 = this.cbD.aLZ;
                    sVar4.qv("2");
                    return;
                }
                return;
            }
            this.cbD.Js();
            sVar = this.cbD.aLZ;
            if (sVar != null) {
                sVar2 = this.cbD.aLZ;
                sVar2.qv("2");
            }
        }
    }
}
