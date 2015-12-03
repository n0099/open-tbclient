package com.baidu.tieba.hottopic.view;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bFE;
    private final /* synthetic */ long boJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j) {
        this.bFE = aVar;
        this.boJ = j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        Animation animation;
        TextView textView;
        TextView textView2;
        boolean z;
        ImageView imageView;
        ImageView imageView2;
        AnimationDrawable animationDrawable;
        LinearLayout linearLayout2;
        TbPageContext tbPageContext;
        ImageView imageView3;
        LinearLayout linearLayout3;
        linearLayout = this.bFE.bFu;
        Animation animation2 = linearLayout.getAnimation();
        animation = this.bFE.bFy;
        if (animation2 == animation) {
            linearLayout3 = this.bFE.bFu;
            linearLayout3.clearAnimation();
            return;
        }
        textView = this.bFE.bFv;
        textView.setVisibility(0);
        textView2 = this.bFE.bFv;
        textView2.setText(ax.x(this.boJ + 1));
        z = this.bFE.bFC;
        if (z) {
            imageView3 = this.bFE.bFt;
            as.c(imageView3, n.e.bless_gif);
        } else {
            imageView = this.bFE.bFt;
            as.c(imageView, n.e.candle_gif);
        }
        a aVar = this.bFE;
        imageView2 = this.bFE.bFt;
        aVar.bFx = (AnimationDrawable) imageView2.getDrawable();
        animationDrawable = this.bFE.bFx;
        animationDrawable.start();
        linearLayout2 = this.bFE.bFu;
        linearLayout2.postDelayed(new e(this), 2000L);
        tbPageContext = this.bFE.bFq;
        ((HotTopicActivity) tbPageContext.getOrignalPage()).Ui();
    }
}
