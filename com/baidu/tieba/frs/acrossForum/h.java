package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ c bCT;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, String str) {
        this.bCT = cVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        FrsActivity frsActivity;
        GifView gifView;
        View.OnClickListener onClickListener;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        GifView gifView2;
        GifView gifView3;
        Runnable runnable;
        if (aVar != null) {
            c cVar = this.bCT;
            frsActivity = this.bCT.bzH;
            cVar.bCO = new GifView(frsActivity.getPageContext().getPageActivity());
            gifView = this.bCT.bCO;
            onClickListener = this.bCT.mOnClickListener;
            gifView.setOnClickListener(onClickListener);
            frsActivity2 = this.bCT.bzH;
            int e = com.baidu.adp.lib.util.k.e(frsActivity2.getPageContext().getPageActivity(), r.e.ds160);
            frsActivity3 = this.bCT.bzH;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e, com.baidu.adp.lib.util.k.e(frsActivity3.getPageContext().getPageActivity(), r.e.ds100));
            frsActivity4 = this.bCT.bzH;
            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(frsActivity4.getPageContext().getPageActivity(), r.e.ds460);
            layoutParams.addRule(11);
            frsActivity5 = this.bCT.bzH;
            ViewGroup Xv = frsActivity5.Wo().Xv();
            gifView2 = this.bCT.bCO;
            Xv.addView(gifView2, layoutParams);
            com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
            aVar2.axE = this.val$url;
            aVar2.axC = this.val$url;
            gifView3 = this.bCT.bCO;
            gifView3.a(aVar2);
            com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
            runnable = this.bCT.bCR;
            eG.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
