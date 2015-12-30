package com.baidu.tieba.hottopic.view;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bJl;
    private final /* synthetic */ long bsA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, long j) {
        this.bJl = aVar;
        this.bsA = j;
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
        BdTypeListView bdTypeListView;
        LinearLayout linearLayout3;
        linearLayout = this.bJl.bJb;
        Animation animation2 = linearLayout.getAnimation();
        animation = this.bJl.bJf;
        if (animation2 == animation) {
            linearLayout3 = this.bJl.bJb;
            linearLayout3.clearAnimation();
        } else {
            textView = this.bJl.bJc;
            textView.setVisibility(0);
            textView2 = this.bJl.bJc;
            textView2.setText(ax.y(this.bsA + 1));
            z = this.bJl.bJj;
            if (z) {
                imageView3 = this.bJl.bJa;
                as.c(imageView3, n.f.bless_gif);
            } else {
                imageView = this.bJl.bJa;
                as.c(imageView, n.f.candle_gif);
            }
            a aVar = this.bJl;
            imageView2 = this.bJl.bJa;
            aVar.bJe = (AnimationDrawable) imageView2.getDrawable();
            animationDrawable = this.bJl.bJe;
            animationDrawable.start();
            linearLayout2 = this.bJl.bJb;
            linearLayout2.postDelayed(new e(this), 2000L);
            tbPageContext = this.bJl.bIX;
            ((HotTopicActivity) tbPageContext.getOrignalPage()).Vk();
        }
        bdTypeListView = this.bJl.aVi;
        bdTypeListView.setEnabled(true);
    }
}
