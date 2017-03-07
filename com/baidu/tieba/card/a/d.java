package com.baidu.tieba.card.a;

import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.v;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
class d implements v.d {
    final /* synthetic */ a buP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.buP = aVar;
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
        audioAnimationView = this.buP.aST;
        audioAnimationView.start();
        frameLayout = this.buP.aSR;
        frameLayout.setVisibility(8);
        tbImageView = this.buP.aSM;
        tbImageView.setVisibility(8);
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        runnable = this.buP.aTd;
        fM.postDelayed(runnable, 3000L);
        com.baidu.adp.lib.g.h fM2 = com.baidu.adp.lib.g.h.fM();
        runnable2 = this.buP.aTg;
        fM2.removeCallbacks(runnable2);
    }
}
