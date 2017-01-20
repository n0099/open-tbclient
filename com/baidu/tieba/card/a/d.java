package com.baidu.tieba.card.a;

import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.v;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
class d implements v.d {
    final /* synthetic */ a bnT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bnT = aVar;
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
        audioAnimationView = this.bnT.aNg;
        audioAnimationView.start();
        frameLayout = this.bnT.aNe;
        frameLayout.setVisibility(8);
        tbImageView = this.bnT.aMZ;
        tbImageView.setVisibility(8);
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        runnable = this.bnT.aNq;
        eE.postDelayed(runnable, 3000L);
        com.baidu.adp.lib.g.h eE2 = com.baidu.adp.lib.g.h.eE();
        runnable2 = this.bnT.aNt;
        eE2.removeCallbacks(runnable2);
    }
}
