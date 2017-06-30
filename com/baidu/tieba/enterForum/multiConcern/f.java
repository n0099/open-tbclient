package com.baidu.tieba.enterForum.multiConcern;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ b bTY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.bTY = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbPageContext tbPageContext;
        View view;
        View view2;
        tbPageContext = this.bTY.aat;
        Animation loadAnimation = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), w.a.anim_recommend_forums_window);
        loadAnimation.setFillAfter(true);
        view = this.bTY.bTQ;
        view.setVisibility(0);
        view2 = this.bTY.bTR;
        view2.startAnimation(loadAnimation);
    }
}
