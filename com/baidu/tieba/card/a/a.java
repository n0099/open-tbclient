package com.baidu.tieba.card.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.aj;
import com.baidu.tieba.play.v;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private View aTA;
    private ImageView aTB;
    private FrameLayout aTD;
    private Animation aTE;
    private AudioAnimationView aTF;
    private View aTG;
    private TextView aTH;
    private aj aTI;
    private QuickVideoView aTy;
    private TbImageView aTz;
    private TbPageContext<?> aat;
    private j bwT;
    private View bwU;
    private TextView bwV;
    private TextView mTitle;
    private View mView;
    private TbImageView.a aTO = new b(this);
    private View.OnClickListener mOnClickListener = new c(this);
    private v.d aRd = new d(this);
    private Runnable aTP = new e(this);
    private QuickVideoView.b aTQ = new f(this);
    private v.b aRe = new g(this);
    private Runnable aTR = new h(this);
    private Runnable aTS = new i(this);

    public a(TbPageContext<?> tbPageContext, View view) {
        this.aat = tbPageContext;
        this.mView = view.findViewById(w.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.aTy = (QuickVideoView) view.findViewById(w.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.aTy.getLayoutParams();
        layoutParams.height = (this.aTy.getWidth() * 9) / 16;
        this.aTy.setLayoutParams(layoutParams);
        this.aTI = new aj(this.aat.getPageActivity());
        this.aTI.aWA();
        this.aTy.setBusiness(this.aTI);
        this.aTy.setOnPreparedListener(this.aRd);
        this.aTy.setOnSurfaceDestroyedListener(this.aTQ);
        this.aTy.setOnErrorListener(this.aRe);
        this.aTz = (TbImageView) view.findViewById(w.h.img_thumbnail);
        this.aTz.setDefaultErrorResource(0);
        this.aTz.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.aTz.setEvent(this.aTO);
        this.aTz.setGifIconSupport(false);
        this.aTA = view.findViewById(w.h.layout_title);
        this.mTitle = (TextView) view.findViewById(w.h.tv_title);
        this.aTB = (ImageView) view.findViewById(w.h.img_play);
        this.aTD = (FrameLayout) view.findViewById(w.h.layout_loading);
        this.aTE = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), w.a.video_title_fade_out);
        this.aTF = (AudioAnimationView) view.findViewById(w.h.playing_indicator);
        this.aTF.setCertainColumnCount(4);
        this.aTF.setColumnColor(w.e.cp_cont_i);
        this.aTG = view.findViewById(w.h.layout_error);
        this.aTH = (TextView) view.findViewById(w.h.video_error_tips);
        this.bwU = view.findViewById(w.h.layout_live_end);
        this.bwV = (TextView) view.findViewById(w.h.video_live_end_tips);
        this.bwT = new j(this);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aq.i(this.mTitle, w.e.cp_cont_i);
        }
        aq.c(this.aTB, w.g.home_ic_video);
        aq.i(this.aTH, w.e.cp_cont_i);
        aq.k(this.aTG, w.e.black_alpha80);
        aq.k(this.aTy, w.e.cp_bg_line_k);
        aq.i(this.bwV, w.e.cp_cont_i);
        aq.k(this.bwU, w.e.black_alpha80);
    }

    public View getView() {
        return this.mView;
    }

    public j Tp() {
        return this.bwT;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void gB(String str) {
        this.aTz.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.aTz.c(str, 10, false);
    }

    public QuickVideoView Ku() {
        return this.aTy;
    }

    public void Kv() {
        this.aTz.setVisibility(0);
        this.aTB.setVisibility(0);
        this.aTD.setVisibility(8);
        if (this.aTA != null) {
            this.aTA.clearAnimation();
        }
        this.aTF.bkR();
        this.aTG.setVisibility(8);
        this.bwU.setVisibility(8);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aTP);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aTR);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aTS);
    }
}
