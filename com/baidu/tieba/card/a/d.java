package com.baidu.tieba.card.a;

import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.v;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
class d implements v.d {
    final /* synthetic */ a bDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bDM = aVar;
    }

    @Override // com.baidu.tieba.play.v.d
    public void onPrepared(v vVar) {
        AudioAnimationView audioAnimationView;
        FrameLayout frameLayout;
        TbImageView tbImageView;
        Runnable runnable;
        Runnable runnable2;
        if (vVar != null) {
            vVar.setLooping(true);
            vVar.setVolume(0.0f, 0.0f);
        }
        audioAnimationView = this.bDM.bDD;
        audioAnimationView.start();
        frameLayout = this.bDM.bDB;
        frameLayout.setVisibility(8);
        tbImageView = this.bDM.bDy;
        tbImageView.setVisibility(8);
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.bDM.bDK;
        fR.postDelayed(runnable, 3000L);
        com.baidu.adp.lib.g.h fR2 = com.baidu.adp.lib.g.h.fR();
        runnable2 = this.bDM.bDL;
        fR2.removeCallbacks(runnable2);
    }
}
