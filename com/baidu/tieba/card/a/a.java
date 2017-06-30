package com.baidu.tieba.card.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.ak;
import com.baidu.tieba.play.v;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private TbPageContext<?> aat;
    private ImageView bDA;
    private FrameLayout bDB;
    private Animation bDC;
    private AudioAnimationView bDD;
    private View bDE;
    private TextView bDF;
    private View bDG;
    private TextView bDH;
    private ak bDI;
    private View.OnClickListener bDJ;
    private j bDw;
    private QuickVideoView bDx;
    private TbImageView bDy;
    private View bDz;
    private TextView mTitle;
    private View mView;
    private TbImageView.a byN = new b(this);
    private View.OnClickListener mOnClickListener = new c(this);
    private v.d aSx = new d(this);
    private Runnable bDK = new e(this);
    private QuickVideoView.b bBO = new f(this);
    private v.b aSy = new g(this);
    private Runnable bBM = new h(this);
    private Runnable bDL = new i(this);

    public a(TbPageContext<?> tbPageContext, View view) {
        this.aat = tbPageContext;
        this.mView = view.findViewById(w.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bDx = (QuickVideoView) view.findViewById(w.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.bDx.getLayoutParams();
        layoutParams.height = (this.bDx.getWidth() * 9) / 16;
        this.bDx.setLayoutParams(layoutParams);
        this.bDI = new ak(this.aat.getPageActivity());
        this.bDI.bcc();
        this.bDx.setBusiness(this.bDI);
        this.bDx.setOnPreparedListener(this.aSx);
        this.bDx.setOnSurfaceDestroyedListener(this.bBO);
        this.bDx.setOnErrorListener(this.aSy);
        this.bDy = (TbImageView) view.findViewById(w.h.img_thumbnail);
        this.bDy.setDefaultErrorResource(0);
        this.bDy.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bDy.setEvent(this.byN);
        this.bDy.setGifIconSupport(false);
        this.bDz = view.findViewById(w.h.layout_title);
        this.mTitle = (TextView) view.findViewById(w.h.tv_title);
        this.bDA = (ImageView) view.findViewById(w.h.img_play);
        this.bDB = (FrameLayout) view.findViewById(w.h.layout_loading);
        this.bDC = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), w.a.video_title_fade_out);
        this.bDD = (AudioAnimationView) view.findViewById(w.h.playing_indicator);
        this.bDD.setCertainColumnCount(4);
        this.bDD.setColumnColor(w.e.cp_cont_i);
        this.bDE = view.findViewById(w.h.layout_error);
        this.bDF = (TextView) view.findViewById(w.h.video_error_tips);
        this.bDG = view.findViewById(w.h.layout_live_end);
        this.bDH = (TextView) view.findViewById(w.h.video_live_end_tips);
        this.bDw = new j(this);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            as.i(this.mTitle, w.e.cp_cont_i);
        }
        as.c(this.bDA, w.g.home_ic_video);
        as.i(this.bDF, w.e.cp_cont_i);
        as.k(this.bDE, w.e.black_alpha80);
        as.k(this.bDx, w.e.cp_bg_line_k);
        as.i(this.bDH, w.e.cp_cont_i);
        as.k(this.bDG, w.e.black_alpha80);
    }

    public View getView() {
        return this.mView;
    }

    public j VO() {
        return this.bDw;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void iM(String str) {
        this.bDy.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bDy.c(str, 10, false);
    }

    public QuickVideoView VP() {
        return this.bDx;
    }

    public void VQ() {
        this.bDy.setVisibility(0);
        this.bDA.setVisibility(0);
        this.bDB.setVisibility(8);
        if (this.bDz != null) {
            this.bDz.clearAnimation();
        }
        this.bDD.bqz();
        this.bDE.setVisibility(8);
        this.bDG.setVisibility(8);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bDK);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bBM);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bDL);
    }

    public void n(View.OnClickListener onClickListener) {
        this.bDJ = onClickListener;
    }
}
