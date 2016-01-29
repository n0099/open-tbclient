package com.baidu.tieba.hottopic.view;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c bMS;
    private final /* synthetic */ long bvG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, long j) {
        this.bMS = cVar;
        this.bvG = j;
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
        linearLayout = this.bMS.bMI;
        Animation animation2 = linearLayout.getAnimation();
        animation = this.bMS.bMM;
        if (animation2 == animation) {
            linearLayout3 = this.bMS.bMI;
            linearLayout3.clearAnimation();
        } else {
            textView = this.bMS.bMJ;
            textView.setVisibility(0);
            textView2 = this.bMS.bMJ;
            textView2.setText(aw.z(this.bvG + 1));
            z = this.bMS.bMQ;
            if (z) {
                imageView3 = this.bMS.bMH;
                ar.c(imageView3, t.f.bless_gif);
            } else {
                imageView = this.bMS.bMH;
                ar.c(imageView, t.f.candle_gif);
            }
            c cVar = this.bMS;
            imageView2 = this.bMS.bMH;
            cVar.bML = (AnimationDrawable) imageView2.getDrawable();
            animationDrawable = this.bMS.bML;
            animationDrawable.start();
            linearLayout2 = this.bMS.bMI;
            linearLayout2.postDelayed(new g(this), 2000L);
            tbPageContext = this.bMS.bME;
            ((HotTopicActivity) tbPageContext.getOrignalPage()).Xz();
        }
        bdTypeListView = this.bMS.aXu;
        bdTypeListView.setEnabled(true);
    }
}
