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
import com.baidu.tieba.play.ak;
import com.baidu.tieba.play.v;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private TbPageContext<?> aas;
    private j bCD;
    private QuickVideoView bCE;
    private TbImageView bCF;
    private View bCG;
    private ImageView bCH;
    private FrameLayout bCI;
    private Animation bCJ;
    private AudioAnimationView bCK;
    private View bCL;
    private TextView bCM;
    private View bCN;
    private TextView bCO;
    private ak bCP;
    private View.OnClickListener bCQ;
    private TextView mTitle;
    private View mView;
    private TbImageView.a bwc = new b(this);
    private View.OnClickListener mOnClickListener = new c(this);
    private v.d aRe = new d(this);
    private Runnable bCR = new e(this);
    private QuickVideoView.b bAV = new f(this);
    private v.b aRf = new g(this);
    private Runnable bAT = new h(this);
    private Runnable bCS = new i(this);

    public a(TbPageContext<?> tbPageContext, View view) {
        this.aas = tbPageContext;
        this.mView = view.findViewById(w.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bCE = (QuickVideoView) view.findViewById(w.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.bCE.getLayoutParams();
        layoutParams.height = (this.bCE.getWidth() * 9) / 16;
        this.bCE.setLayoutParams(layoutParams);
        this.bCP = new ak(this.aas.getPageActivity());
        this.bCP.aXR();
        this.bCE.setBusiness(this.bCP);
        this.bCE.setOnPreparedListener(this.aRe);
        this.bCE.setOnSurfaceDestroyedListener(this.bAV);
        this.bCE.setOnErrorListener(this.aRf);
        this.bCF = (TbImageView) view.findViewById(w.h.img_thumbnail);
        this.bCF.setDefaultErrorResource(0);
        this.bCF.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bCF.setEvent(this.bwc);
        this.bCF.setGifIconSupport(false);
        this.bCG = view.findViewById(w.h.layout_title);
        this.mTitle = (TextView) view.findViewById(w.h.tv_title);
        this.bCH = (ImageView) view.findViewById(w.h.img_play);
        this.bCI = (FrameLayout) view.findViewById(w.h.layout_loading);
        this.bCJ = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), w.a.video_title_fade_out);
        this.bCK = (AudioAnimationView) view.findViewById(w.h.playing_indicator);
        this.bCK.setCertainColumnCount(4);
        this.bCK.setColumnColor(w.e.cp_cont_i);
        this.bCL = view.findViewById(w.h.layout_error);
        this.bCM = (TextView) view.findViewById(w.h.video_error_tips);
        this.bCN = view.findViewById(w.h.layout_live_end);
        this.bCO = (TextView) view.findViewById(w.h.video_live_end_tips);
        this.bCD = new j(this);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aq.i(this.mTitle, w.e.cp_cont_i);
        }
        aq.c(this.bCH, w.g.home_ic_video);
        aq.i(this.bCM, w.e.cp_cont_i);
        aq.k(this.bCL, w.e.black_alpha80);
        aq.k(this.bCE, w.e.cp_bg_line_k);
        aq.i(this.bCO, w.e.cp_cont_i);
        aq.k(this.bCN, w.e.black_alpha80);
    }

    public View getView() {
        return this.mView;
    }

    public j Ux() {
        return this.bCD;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m13if(String str) {
        this.bCF.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.bCF.c(str, 10, false);
    }

    public QuickVideoView Uy() {
        return this.bCE;
    }

    public void Uz() {
        this.bCF.setVisibility(0);
        this.bCH.setVisibility(0);
        this.bCI.setVisibility(8);
        if (this.bCG != null) {
            this.bCG.clearAnimation();
        }
        this.bCK.bmp();
        this.bCL.setVisibility(8);
        this.bCN.setVisibility(8);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bCR);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bAT);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bCS);
    }

    public void n(View.OnClickListener onClickListener) {
        this.bCQ = onClickListener;
    }
}
