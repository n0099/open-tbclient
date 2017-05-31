package com.baidu.tieba.card.a;

import android.widget.FrameLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.v;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
class d implements v.d {
    final /* synthetic */ a bCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bCT = aVar;
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
        audioAnimationView = this.bCT.bCK;
        audioAnimationView.start();
        frameLayout = this.bCT.bCI;
        frameLayout.setVisibility(8);
        tbImageView = this.bCT.bCF;
        tbImageView.setVisibility(8);
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.bCT.bCR;
        fS.postDelayed(runnable, 3000L);
        com.baidu.adp.lib.g.h fS2 = com.baidu.adp.lib.g.h.fS();
        runnable2 = this.bCT.bCS;
        fS2.removeCallbacks(runnable2);
    }
}
